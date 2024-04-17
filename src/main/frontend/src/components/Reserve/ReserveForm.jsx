import React, {useContext, useEffect, useState} from 'react'
import './ReserveForm.css'
import {LoginContext} from "../../contexts/LoginContextProvider";
import {Link, useNavigate} from "react-router-dom";
const ReserveForm = ({sectorInfo, getTableInfo, tableInfo, cafeIdx}) => {
    console.log("ReserveForm.jsx ---------------------------------- Mounted")

    const [sIndex, setSIndex] = useState(0);
    const [tIndex, setTIndex] = useState(0);
    const [tableSeatNo, setTableSeatNo] = useState(0);
    const [tableDescription, setTableDescription] = useState(0);
    const [tableDBidx, setTableDBidx] = useState(null);

    const navigate = useNavigate();


    if(sectorInfo[0] === undefined || sectorInfo[0] === null)
    {
        return null;
    }

    const selectSector = (sectorIdx) =>{
        //sectorInfo에서 해당 idx를 가진 인덱스를 찾는다
        tableInfo = null;
        setSIndex(sectorInfo.findIndex(sector=>sector.sectorIdx === sectorIdx));
        getTableInfo(sectorIdx);
    }

    const selectTable = (tableTemplateIdx)=>{
        setTableDBidx(tableTemplateIdx);
        console.log("tableInfo : ", tableInfo)
        const index = tableInfo.findIndex(table=>table.tableTemplateId === tableTemplateIdx);
        console.log("tableInfo.findIndex : ",tableInfo.findIndex(table=>table.tableTemplateId === tableTemplateIdx))
        if(index !== -1)
        {
            setTIndex(index)
            setTableSeatNo(tableInfo[index].seatNo);
            setTableDescription(tableInfo[index].tableDescription);
            console.log("tIndex : ", tIndex)
        }


    }

    /**
     * 카페 Sector 선택 버튼 렌더링
     */
    const renderSector = ()=>{
        const btn = [];
        for(let i=0; i<sectorInfo.length; i++)
        {
            const sectorIdx = sectorInfo[i].sectorIdx;
            btn.push(<button key={sectorIdx} onClick={()=> selectSector(sectorIdx)}>{sectorInfo[i].sectorName}</button>)
            //여기서 키 값을 빼내서 테이블 템플릿 정보 불러온다
        }
        return btn;
    }
    /**
     *  sector size x,y 를 통해 크기를 정하고
     *  tableTemplate 정보에 따라 해당하는 좌표에 컴포넌트 배치
     */
    const renderTable = (x,y) => {
        const row = [];
        for (let i = 0; i < y; i++) {
            const cell = [];
            for (let j = 0; j < x; j++)
            {
                cell.push(<td key={j}>__</td>);
            }
            row.push(<tr key={i}>{cell}</tr>);
        }

        for (let i=0; i<tableInfo.length; i++)
        {
            const table = tableInfo[i];
            if (table.tableTemplateX <= x && table.tableTemplateY <= y) {
                const rowIndex = row[table.tableTemplateY - 1];
                rowIndex.props.children[table.tableTemplateX - 1] = <td key={table.tableTemplateId}>__</td>;
            }

        }

        for(let i =0; i< tableInfo.length; i++)
        {
            const table = tableInfo[i];
            const rowIndex = row[table.tableTemplateY-1];

            if(table.componentId === 1)
            {
                if (!table.isUsing)
                {
                    rowIndex.props.children[table.tableTemplateX-1] = <td><button onClick={()=>selectTable(table.tableTemplateId)}>T{table.seatCount}</button></td>
                }
                else
                {
                    rowIndex.props.children[table.tableTemplateX-1] = <td>U</td>
                }

            }
            else if (table.componentId === 2)
            {
                rowIndex.props.children[table.tableTemplateX-1] = <td>D</td>
            }
            else if(table.componentId === 7)
            {
                rowIndex.props.children[table.tableTemplateX-1] = <td>S</td>
            }
        }

        return row;
    };

    return (
        <>
            {renderSector()}
            <table border={1}>
                <tbody>
                {renderTable(sectorInfo[sIndex].sectorSizeX, sectorInfo[sIndex].sectorSizeY)}
                </tbody>
            </table>
            <div>
                <p>Table No. {tableSeatNo || 'none'}</p>
                <p>{tableDescription || ''}</p>
                <Link to="/beverage" state={{cafeIdx: cafeIdx,  tableTemplateIdx: tableDBidx}}>음료 주문하기</Link>
            </div>

        </>
    )
}

export default ReserveForm;
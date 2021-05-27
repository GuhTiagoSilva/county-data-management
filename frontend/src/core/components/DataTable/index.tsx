import axios from "axios";
import React, { useEffect, useState } from "react";
import { CountyPage } from "../../types/countyView";
import { formatLocalDate } from "../../utils/format";
import { BASE_URL } from "../../utils/request";
import Pagination from "../Pagination";

const DataTable = () => {

  const [activePage, setActivePage] = useState(0);
  const [page, setPage] = useState<CountyPage>({
    first: true,
    last: true,
    number: 0,
    totalElements: 0,
    totalPages: 0,
  });

  useEffect(() => {
    axios
      .get(
        `${BASE_URL}/counties?page=${activePage}&linesPerPage=3&direction=ASC&orderBy=name`
      )
      .then((response) => {
        setPage(response.data);
      });
  }, [activePage]);

  const changePage = (index: number) =>{
    setActivePage(index);
  }

  return (
    <>
      <Pagination page={page} onPageChange={changePage}  />
      <div className="table-responsive">
        <table className="table table-striped table-sm">
          <thead>
            <tr>
              <th>ID</th>
              <th>Aplicação</th>
              <th>Valor Orcado</th>
              <th>Valor Arrecadado</th>
              <th>Data Receita</th>
              <th>Tipo Receita</th>
            </tr>
          </thead>
          <tbody>
            {page.content?.map((item) => (
              <tr key={item.id}>
                <td>{item.id}</td>
                <td>{item.application}</td>
                <td>
                  <span>R$</span>
                  {item.budgetedValue.toFixed(2)}
                </td>
                <td>
                  <span>R$</span>
                  {item.collectedValue.toFixed(2)}{" "}
                </td>
                <td> {formatLocalDate(item.incomeDate, "dd/MM/yyyy")} </td>
                <td> {item.type == 1 ? "RECEITA_1" : "RECEITA_2"} </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
};

export default DataTable;

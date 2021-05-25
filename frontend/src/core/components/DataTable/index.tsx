import React from "react";

const DataTable = () => {
  return (
    <div className="table-responsive">
      <table className="table table-striped table-sm">
        <thead>
          <tr>
            <th>ID</th>
            <th>Descrição</th>
            <th>Valor Orcado</th>
            <th>Valor Arrecadado</th>
            <th>Data Receita</th>
            <th>Fonte</th>
            <th>Aplicação</th>
            <th>Tipo Receita</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>1</td>
            <td>Educação</td>
            <td>34.00</td>
            <td>25.00</td>
            <td>23/05/2021</td>
            <td>Fonte Teste</td>
            <td>Teste</td>
            <td>1</td>
          </tr>
          <tr>
            <td>2</td>
            <td>Cultura</td>
            <td>34.00</td>
            <td>25.00</td>
            <td>23/05/2021</td>
            <td>Fonte Teste</td>
            <td>Teste</td>
            <td>1</td>
          </tr>
          <tr>
            <td>3</td>
            <td>Musica</td>
            <td>34.00</td>
            <td>25.00</td>
            <td>23/05/2021</td>
            <td>Fonte Teste</td>
            <td>Teste</td>
            <td>1</td>
          </tr>
          <tr>
            <td>4</td>
            <td>Saude</td>
            <td>34.00</td>
            <td>25.00</td>
            <td>23/05/2021</td>
            <td>Fonte Teste</td>
            <td>Teste</td>
            <td>1</td>
          </tr>
          <tr>
            <td>5</td>
            <td>Transporte</td>
            <td>34.00</td>
            <td>25.00</td>
            <td>23/05/2021</td>
            <td>Fonte Teste</td>
            <td>Teste</td>
            <td>1</td>
          </tr>
          <tr>
            <td>6</td>
            <td>Alimentacao</td>
            <td>34.00</td>
            <td>25.00</td>
            <td>23/05/2021</td>
            <td>Fonte Teste</td>
            <td>Teste</td>
            <td>1</td>
          </tr>
        </tbody>
      </table>
    </div>
  );
};

export default DataTable;

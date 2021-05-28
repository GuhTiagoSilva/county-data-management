import BarChart from "../../core/components/BarChart";
import DataTable from "../../core/components/DataTable";
import DonutChart from "../../core/components/DonutChart";

const IncomeList = () => {
  return (
    <div className="container">
      <div className="row px-3">
        <div className="col-sm-6">
          <h5 className="text-center text-secondary mt-5" >Taxa de Valores Arrecadados</h5>
          <BarChart />
        </div>
        <div className="col-sm-6">
        <h5 className="text-center text-secondary mt-5" >Porcentagem de Valores Arrecadados</h5>
            <DonutChart/>
        </div>
      </div>
      <div className="mt-5">
          <h5 className="text-center text-secondary mb-5">Dados Gerais</h5>
        <DataTable />
      </div>
    </div>
  );
};

export default IncomeList;

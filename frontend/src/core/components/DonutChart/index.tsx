import axios from "axios";
import { useEffect, useState } from "react";
import Chart from "react-apexcharts";
import { IncomeSum } from "../../types/income";
import { BASE_URL } from "../../utils/request";

type ChartData = {
  series: number[];
  labels: string[];
};

const DonutChart = () => {
  const [chartData, setChartData] = useState<ChartData>({
    labels: [],
    series: [],
  });

  useEffect(() => {
    axios.get(`${BASE_URL}/incomes`).then((response) => {
      const data = response.data as IncomeSum[];
      const myLabels = data.map((item) => item.name);
      const mySeries = data.map((item) => item.total);
      setChartData({ labels: myLabels, series: mySeries });
    });
  }, []);

  const options = {
    legend: {
      show: true,
    },
  };

  return (
    <Chart
      options={{ ...options, labels: chartData.labels }}
      series={chartData.series}
      type="donut"
      height="240"
    />
  );
};

export default DonutChart;

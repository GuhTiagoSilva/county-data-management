import axios from 'axios';
import React from 'react';
import Chart from 'react-apexcharts';
import { IncomeSum } from '../../types/income';
import { BASE_URL } from '../../utils/request';

type ChartData = {
    series: number[] ,
    labels: string[]
}

const DonutChart = () => {

    //Forma errada
    let chartData : ChartData = {
        labels: [],
        series: []
    };

    axios.get(`${BASE_URL}/incomes`)
    .then(response => {
        const data = response.data as IncomeSum[];
        const myLabels = data.map(item => item.name);
        const mySeries = data.map(item => item.total);
        chartData = {labels: myLabels, series: mySeries}
        console.log(chartData);
    });
    

    const mockData = {
        series: [477138, 499928, 444867, 220426, 473088],
        labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    }
    
    const options = {
        legend: {
            show: true
        }
    }

    return (
        <Chart
            options={{...options, labels: chartData.labels}}
            series={chartData.series}
            type="donut"
            height="240"
        />
    )
}

export default DonutChart;
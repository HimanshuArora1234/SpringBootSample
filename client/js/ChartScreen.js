import React, { PropTypes } from 'react';
import {Line} from 'react-chartjs-2';
import {Bar} from 'react-chartjs-2';
import {Pie} from 'react-chartjs-2';
export default class ChartScreen extends React.Component {

  constructor(props) {
    super(props);
  }

  render() {
      const data = {
      labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
      datasets: [
        {
          label: 'My First dataset',
          fill: false,
          lineTension: 0.1,
          backgroundColor: 'rgba(75,192,192,0.4)',
          borderColor: 'rgba(75,192,192,1)',
          borderCapStyle: 'butt',
          borderDash: [],
          borderDashOffset: 0.0,
          borderJoinStyle: 'miter',
          pointBorderColor: 'rgba(75,192,192,1)',
          pointBackgroundColor: '#fff',
          pointBorderWidth: 1,
          pointHoverRadius: 5,
          pointHoverBackgroundColor: 'rgba(75,192,192,1)',
          pointHoverBorderColor: 'rgba(220,220,220,1)',
          pointHoverBorderWidth: 2,
          pointRadius: 1,
          pointHitRadius: 10,
          data: [65, 59, 80, 81, 56, 55, 40]
        }
      ],
    };
    const bar_data = {
      labels: this.props.refUsers.map(u => u.name),
      datasets: [
        {
          label: 'My First dataset',
          backgroundColor: 'rgba(255,99,132,0.2)',
          borderColor: 'rgba(255,99,132,1)',
          borderWidth: 1,
          hoverBackgroundColor: 'rgba(255,99,132,0.4)',
          hoverBorderColor: 'rgba(255,99,132,1)',
          data: this.props.refUsers.map(u => u.id)
        }
      ]
    };
    const pie_data = {
    	labels: [
    		'Red',
    		'Green',
    		'Yellow'
    	],
    	datasets: [{
    		data: [300, 50, 100],
    		backgroundColor: [
    		'#FF6384',
    		'#36A2EB',
    		'#FFCE56'
    		],
    		hoverBackgroundColor: [
    		'#FF6384',
    		'#36A2EB',
    		'#FFCE56'
    		]
    	}]
    };

    return (
      <div>
        <div className="bar"><Bar data={bar_data}/></div>
        <div className="pie"><Pie data={pie_data}/></div>
        <div className="line"><Line data={data}/></div>
      </div>
    );
  }


}

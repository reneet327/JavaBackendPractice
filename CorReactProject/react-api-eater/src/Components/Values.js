import React from 'react';
import * as api from '../utils/api';

class Values extends React.Component {
	state = {
		values: []
	};

	callValues = () => {
		api.fetchValues().then(response => {
			console.log('callValues: ', response);
			this.setState(() => {
				return {
					values: response
				};
			});
			console.log('after SetState: ', this.state.values);
		});
	};

	componentDidMount() {
		this.callValues();
		console.log('componentDidMount: ', this.state.values);
	}

	render() {
		return <div>{this.state.values}</div>;
	}
}

export default Values;

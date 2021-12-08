import React, { Component } from 'react';
import InfoCard from '../InfoCard/InfoCard';


class InfoCardRow extends Component {
    constructor(props) {
        super(props);
        this.state = {};
    }

    componentDidMount() {
        // Auto initialize all the things!
    }

    render() {
        return (
            <div className="row">
                {Object.keys(this.props.cards).map(key => (
                    <InfoCard key={key} columns={this.props.columns} heading={key} data={this.props.cards[key]} />
                ))}
            </div>
        )
    }
}

export default InfoCardRow;
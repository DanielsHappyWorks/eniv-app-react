import React, { Component } from 'react';
import './InfoCard.scss';


class InfoCard extends Component {
    constructor(props) {
        super(props);
        this.state = {};
    }


    componentDidMount() {
    }

    render() {
        return (
            <div className={this.props.columns}>
                <div className="card InfoCard">
                    <h5 className="header">{this.props.heading}</h5>
                    <p>{this.props.data}</p>
                </div>
            </div>
        )
    }
}

export default InfoCard;
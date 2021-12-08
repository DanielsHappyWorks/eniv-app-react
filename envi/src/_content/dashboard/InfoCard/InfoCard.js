import React, { Component } from 'react';
import './InfoCard.scss';
import { useNavigate } from "react-router-dom";

function InfoCardWithNavigate(props) {
    let navigate = useNavigate();
    return <InfoCard {...props} navigate={navigate} />
}

class InfoCard extends Component {
    constructor(props) {
        super(props);
        this.state = {};
    }

    routeChange=()=> {
        let path = "/data/" + this.props.item.id;
        this.props.navigate(path);
    }

    componentDidMount() {
    }

    render() {
        return (
            <div className="InfoCard" onClick={this.routeChange}>
                <h2 className="header">{this.props.item.name}</h2>
                <p>Location: {this.props.item.longitude},{this.props.item.latitude}</p>
                <p>Next Visit: {new Date(this.props.item.nextDate * 1000).toLocaleString()}</p>
                <p>Author: {this.props.item.author}</p>
            </div>
        )
    }
}

export default InfoCardWithNavigate;
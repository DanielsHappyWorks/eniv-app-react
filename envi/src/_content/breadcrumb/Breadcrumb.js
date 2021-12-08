import React, { Component } from 'react';
import './breadcrumb.scss';
import { BrowserRouter, Link } from 'react-router-dom';


class SuperCoolComponent extends Component {

  constructor(props) {
    super(props);
    this.state = {
      path: this.props.path
    };

    this.emls = this.state.path.split("/");
    this.elmConcat = "/";
  }

  componentDidMount() {
  }

  render() {
    if (this.state.path) {
      return (
        <BrowserRouter>
        {
        this.emls.map((i, e) => {     
           console.log("Entered", this.elms, e, this.elmConcat);
           this.elmConcat = this.elmConcat + e;            
           return (<Link to={i}>{e}</Link>) 
        })}
        </BrowserRouter>
      )
    }
    return (
      <div>Failed</div>
    )
  }
}

export default SuperCoolComponent;
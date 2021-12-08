import React, { Component } from 'react';
import './content.scss';
import { Route, Routes } from 'react-router-dom';
import UnderConstruction from './under_construction/UnderConstruction';
import DashboardComponent from './dashboard/Dashboard';
import Data from './data/Data'


class Content extends Component {
  render() {
    return (
      <main>
        <div>
            <Routes>
                <Route exact path="/" element={<DashboardComponent name="Dashboard"/>} />
                <Route exact path="/assets" element={<UnderConstruction name="Asset Register"/>} />
                <Route exact path="/drawings" element={<UnderConstruction name="Drawings"/>} />
                <Route exact path="/admin" element={<UnderConstruction name="Admin"/>} />
                <Route exact path="/projects" element={<UnderConstruction name="Projects"/>} />
                <Route exact path="/data/:id" element={<Data name="Data"/>} />
            </Routes>
        </div>
      </main>
    )
  }
}

export default Content;
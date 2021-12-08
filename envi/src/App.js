import React from 'react';
import Header from './_header/Header.js';
import Content from './_content/Content.js';
import Footer from './_footer/Footer.js';
import { BrowserRouter } from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Header/>
        <Content/>
        <Footer/>
      </BrowserRouter>
    </div>
  );
}

export default App;
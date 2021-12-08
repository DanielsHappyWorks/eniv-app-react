import React, { Component } from 'react';
import './map.scss';
import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet'

class MapComponent extends Component {
  constructor(props) {
    super(props);
  }

  componentDidMount() {
  }

  render() {
    console.log(this.props);
    const position = [this.props.lat, this.props.long]
      return (
        <div id="map">
        <MapContainer  style={{ height: "500px" }}  center={position} zoom={10} scrollWheelZoom={false}>
        <TileLayer
        attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
        url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
        />
        <Marker position={position}>
        <Popup>Text</Popup>
        </Marker>
        </MapContainer>
        </div>
      )
  }
}

export default MapComponent;
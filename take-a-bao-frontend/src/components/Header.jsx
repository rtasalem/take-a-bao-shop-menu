import Button from "react-bootstrap/Button";
import Container from "react-bootstrap/Container";
import Form from "react-bootstrap/Form";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import NavDropdown from "react-bootstrap/NavDropdown";
import "../styles/Header.css";
import { useState } from "react";
import axios from "axios";

const Header = () => {
  return (
    <Navbar expand="lg" className="header">
      <Container fluid>
        <Navbar.Brand href="/" className="justify-content-center">
          take a bao
        </Navbar.Brand>
        <Navbar.Toggle aria-controls="navbarScroll" />
        <Navbar.Collapse id="navbarScroll">
          <Nav
            className="me-auto my-2 my-lg-0"
            style={{ maxHeight: "100px" }}
            navbarScroll
          >
            <NavDropdown title="Menu" id="navbarScrollingDropdown">
              <NavDropdown.Item href="/baozi">Baozi</NavDropdown.Item>
              <NavDropdown.Item href="/sides">Sides</NavDropdown.Item>
              <NavDropdown.Item href="/desserts">Desserts</NavDropdown.Item>
              {/* <NavDropdown.Item href="/drinks">Drinks</NavDropdown.Item> */}
            </NavDropdown>
            {/* <Nav.Link href="/events">Events</Nav.Link> */}
          </Nav>
          {/* <Form className="d-flex">
            <Form.Control
              type="search"
              placeholder="Have a look around!"
              className="me-2"
              aria-label="Search"
            />
            <Button variant="outline-success">Search</Button>
          </Form> */}
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};
export default Header;

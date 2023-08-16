import Button from "react-bootstrap/Button";
import Container from "react-bootstrap/Container";
import Form from "react-bootstrap/Form";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import NavDropdown from "react-bootstrap/NavDropdown";
import "bootstrap/dist/css/bootstrap.min.css";

const Header = () => {
  return (
    <Navbar expand="lg" className="bg-body-tertiary">
      <link rel="preconnect" href="https://fonts.googleapis.com" />
      <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
      <link
        href="https://fonts.googleapis.com/css2?family=Mr+Dafoe&display=swap"
        rel="stylesheet"
      ></link>
      <Container fluid>
        <Navbar.Brand href="/">Take A Bao</Navbar.Brand>
        <Navbar.Toggle aria-controls="navbarScroll" />
        <Navbar.Collapse id="navbarScroll">
          <Nav
            className="me-auto my-2 my-lg-0"
            style={{ maxHeight: "100px" }}
            navbarScroll
          >
            <Nav.Link href="/about-us">About Us</Nav.Link>
            <Nav.Link
              href="https://www.instagram.com/_takeabao/"
              target="_blank"
            >
              Instagram
            </Nav.Link>
            <Nav.Link
              href="https://www.justgiving.com/crowdfunding/TakeaBao?utm_term=z2xyP8dk5"
              target="_blank"
            >
              Just Giving
            </Nav.Link>
            <NavDropdown title="Menu" id="navbarScrollingDropdown">
              <NavDropdown.Item href="/baozi">Baozi</NavDropdown.Item>
              <NavDropdown.Item href="/sides">Sides</NavDropdown.Item>
              <NavDropdown.Item href="/desserts">Desserts</NavDropdown.Item>
              <NavDropdown.Item href="/drinks">Drinks</NavDropdown.Item>
            </NavDropdown>
          </Nav>
          <Form className="d-flex">
            <Form.Control
              type="search"
              placeholder="Search our menu!"
              className="me-2"
              aria-label="Search"
            />
            <Button variant="outline-success">Search</Button>
          </Form>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};
export default Header;

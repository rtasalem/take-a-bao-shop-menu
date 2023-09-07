# Take A Bao: Read-Only Shop Menu 👩🏻‍🍳🤤
### Acknowledgements
Full credit and a massive thank you for the inspiration behind this project goes to my very talented close friend, Claire Huang. I dedicate this project to her in the hopes that I'll get a lifetime discount on her homemade bao. If you want to find out more about Claire's fundraising work, check out the Take A Bao [Instragram](https://www.instagram.com/_takeabao/) and [Just Giving](https://www.justgiving.com/crowdfunding/TakeaBao?utm_term=z2xyP8dk5) pages. Photography for the website by Claire Huang and Rana Salem. 
### Just A Heads-Up
When I first told Claire that I was working on this project for her, her excitement further inspired me to develop this idea into what will (hopefully) be a real, full-fledged website where orders can be placed and upcoming and past fundraising events can be viewed as blog-style articles. This large-scale website is currently still in development and will be contained in a separate repository (a link will be provided here in the coming months).
## Background
Take A Bao is a pop-up bao bar founded by my close friend, Claire. When Claire first told me about Take A Bao, I wanted to make a small-scale website for her as a surprise and to develop my skills as a full stack developer. This project comprises a read-only online shop menu - a _very_ early prototype. A RESTful API feeds data from a H2 (in-memory) database to a React application that uses Bootstrap for visually pleasing web pages. 
## Libraries & Technologies
**Spring Boot:**
- The API was built using RESTful architecture, adopting the following Spring Boot dependencies: Spring Boot DevTools, Spring Web, Spring Reactive Web, Spring Data JPA, H2, Validation.
- CRUD operations are present throughout the API and have been fully tested via Postman (see below for the API documentation).

**React:**
- The frontend was developed using the React. This allowed for intuitive development via components which are readily reused throughout the application to reduce repititive code. 

**Bootstrap:**
- The majority of the styling for the website was achieved via [Bootstrap](https://getbootstrap.com/). Bootstrap was chosen for it's wide recognition and also for it's responsive design e.g. styling which maintains itself when viewed from different screen sizes. 

**Figma:**
- Figma was used to create SVGs (scalable vector graphics) of the Instagram and JustGiving icons that are seen along the Footer of the React applicaiton. SVGs allow for higher quality when rendered through React.
## Documentation
- NOTE: Link Postman documentation here. 
- NOTE: Implement Swagger Documentation for the API and discuss this here.
## Learning Milestones
This project further exposed me to the Bootstrap framework and how to implement it within React and to further customise the styling. It was through this project that I also further developed my understanding of well-structured, sophisticated documentation. 
## Getting Started
After cloning the repository, import the take-a-bao-api as a Maven project and run it as a Spring Boot Application. The instructions for running the take-a-bao-frontend React application can be found in a dedicated [README.md](https://github.com/rtasalem/take-a-bao-shop-menu/blob/main/take-a-bao-frontend/README.md) file in this repository.

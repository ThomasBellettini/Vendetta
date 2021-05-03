const express = require("express");
const app = express();

app.use(express.json());

const display = require("./src/display/Route");

app.listen(3000, () => {
    console.log("Web Server has been launch ...");
    console.log("Wait Request ...");
});

display(app);

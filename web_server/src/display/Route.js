module.exports = (app) => {
    const content = require("../chat/ChatMap")
    const fs = require('fs');
    const path = require('path');

    content.newChatMessage("[SYS] Bienvenue à tous !");

    function printIP(msg, req)
    {
        const ip = req.headers['x-forwarded-for'] || req.connection.remoteAddress;
        console.log(ip + " Has send message : " + msg);
    }

    app.post("/content/", (req, res) => {
        let sympa = "";
        for (let i = 0; i < content.getMap().size; i++) {
            sympa += "[🍌] > ";
            sympa += content.getMap().get(i);
            sympa += "<br>";
        }
        fs.readFile("./html/original.html", 'utf8', function (err,data) {
            if (err) {
                return console.log(err);
            }
            res.send({
                msg: sympa
            })
        });
    })

    app.get("/", (req, res) => {
        let sympa = "";
        for (let i = 0; i < content.getMap().size; i++) {
            sympa += "[🍌] > ";
            sympa += content.getMap().get(i);
            sympa += "<br>";
        }
        fs.readFile("./html/original.html", 'utf8', function (err,data) {
            if (err) {
                return console.log(err);
            }
            var result = data.replace("%chat_msg%", sympa);

            fs.writeFile("./html/index.html", result, 'utf8', function (err) {
                if (err) return console.log(err);
                res.sendfile(path.join(__dirname, "../../html/index.html"));
            });
        });
    })

    app.post("/", (req, res) => {
        if (content.getMap().size <= 0) {
            res.send({
                msg: "No Content Was Found !"
            })
        } else {
            let jsonObject = {};
            content.getMap().forEach((value, key) => {
                jsonObject[key] = value
            });
            res.send({
                chatLog: JSON.stringify(jsonObject)
            });
        }
    })
    
    app.post("/newmsg/:id", (req, res) => {

        res.send({
            sucess: "Sucess"
        })
        let msg = req.params.id.toString();
        printIP(msg, req);
        if (msg.includes("卍") || msg.length >= 100) {
            return;
        }
        content.newChatMessage(msg);
    })
}

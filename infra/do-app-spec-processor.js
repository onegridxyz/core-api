const fs = require('fs');

let rawdata = fs.readFileSync('infra/do-app-spec-input.json');
let appSpecObj = JSON.parse(rawdata);
appSpecObj['services'][0]['image']['tag'] = process.env.IMAGE_TAG

fs.writeFile ("infra/do-app-spec.json", JSON.stringify(appSpecObj), function(err) {
    if (err) {
      throw err;
    }
  }
);

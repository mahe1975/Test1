$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/featurefiles/leadership.feature");
formatter.feature({
  "name": "Save leadership team members info into a csv file",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Add name, position, and description into a .csv file",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Smoke"
    }
  ]
});
formatter.step({
  "name": "Launch MailChimps web page",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.launch()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Navigate to MailChimps about page",
  "keyword": "When "
});
formatter.match({
  "location": "steps.navigateAbout()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Add leadership team members info into a csv file",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.addMembers()"
});
formatter.result({
  "status": "passed"
});
});
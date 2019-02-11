//-------------------------------------------------
var paper1 = [
{
"question":"Software testing activities should start",
"answer": [
"as soon as the code is written",
"during the design stage",
"when the requirements have been formally documented",
"as soon as possible in the development life cycle"
],
"correct":"3"
},
{
"question":"Faults found by users are due to:",
"answer": [
"Poor quality software",
"Poor software and poor testing",
"bad luck",
"insufficient time for testing"
],
"correct":"1"
},
{
"question":"What is the main reason for testing software before releasing it?",
"answer": [
"to show that system will work after release",
"to decide when the software is of sufficient quality to release",
"to find as many bugs as possible before release",
"to give information for a risk based decision about release"
],
"correct":"3"
},
{
"question":"which of the following statements is not true",
"answer": [
"performance testing can be done during unit testing as well as during the testing of whole system",
"The acceptance test does not necessarily include a regression test",
"Verification activities should not involve testers (reviews, inspections et",
"Test environments should be as similar to production environments as possible"
],
"correct":"2"
},
{
"question":"When reporting faults found to developers, testers should be:",
"answer": [
"as polite, constructive and helpful as possible",
"firm about insisting that a bug is not a \"feature\" if it should be fixed",
"diplomatic, sensitive to the way they may react to criticism",
"All of the above"
],
"correct":"3"
},
{
"question":"In which order should tests be run?",
"answer": [
"the most important tests first",
"the most difficult tests first(to allow maximum time for fixing)",
"the easiest tests first(to give initial confidence)",
"the order they are thought of"
],
"correct":"0"
},
{
"question":"The later in the development life cycle a fault is discovered, the more expensive it is to fix. why?",
"answer": [
"the documentation is poor, so it takes longer to find out what the software is doing.",
"wages are rising",
"the fault has been built into more documentation,code,tests, etc",
"none of the above"
],
"correct":"2"
},
{
"question":"Which is not true-The black box tester",
"answer": [
"should be able to understand a functional specification or requirements document",
"should be able to understand the source code.",
"is highly motivated to find faults",
"is creative to find the system's weaknesses"
],
"correct":"1"
},
{
"question":"A test design technique is",
"answer": [
"a process for selecting test cases",
"a process for determining expected outputs",
"a way to measure the quality of software",
"a way to measure in a test plan what has to be done"
],
"correct":"0"
},
{
"question":"Testware(test cases, test dataset)",
"answer": [
"needs configuration management just like requirements, design and code",
"should be newly constructed for each new version of the software",
"is needed only until the software is released into production or use",
"does not need to be documented and commented, as it does not form part of the released<br>software system"
],
"correct":"0"
},
{
"question":"An incident logging system",
"answer": [
"only records defects",
"is of limited value",
"is a valuable source of project information during testing if it contains all incidents",
"should be used only by the test team."
],
"correct":"2"
},
{
"question":"Increasing the quality of the software, by better development methods, will affect the time<br>needed for testing (the test phases) by:",
"answer": [
"reducing test time",
"no change",
"increasing test time",
"can't say"
],
"correct":"0"
},
{
"question":"Coverage measurement",
"answer": [
"is nothing to do with testing",
"is a partial measure of test thoroughness",
"branch coverage should be mandatory for all software",
"can only be applied at unit or module testing, not at system testing"
],
"correct":"1"
},
{
"question":"When should you stop testing?",
"answer": [
"when time for testing has run out.",
"when all planned tests have been run",
"when the test completion criteria have been met",
"when no faults have been found by the tests run"
],
"correct":"2"
},
{
"question":"Which of the following is true?",
"answer": [
"Component testing should be black box, system testing should be white box.",
"if u find a lot of bugs in testing, you should not be very confident about the quality of software",
"the fewer bugs you find,the better your testing was",
"the more tests you run, the more bugs you will find."
],
"correct":"1"
},
{
"question":"What is the important criterion in deciding what testing technique to use?",
"answer": [
"how well you know a particular technique",
"the objective of the test",
"how appropriate the technique is for testing the application",
"whether there is a tool to support the technique"
],
"correct":"1"
},
{
"question":"If the pseudocode below were a programming language ,how many tests are required to achieve<br>100% statement coverage?<br>1. If x=3 then<br>2. Display_messageX;<br>3. If y=2 then<br>4. Display_messageY;<br>5. Else<br>6. Display_messageZ;<br>7. Else<br>8. Display_messageZ;",
"answer": [
"1",
"2",
"3",
"4"
],
"correct":"2"
},
{
"question":"Using the same code example as question 17,how many tests are required to achieve 100%<br>branch/decision coverage?",
"answer": [
"1",
"2",
"3",
"4"
],
"correct":"2"
},
{
"question":"Which of the following is NOT a type of non-functional test?",
"answer": [
"State-Transition",
"Usability",
"Performance",
"Security"
],
"correct":"0"
},
{
"question":"Which of the following tools would you use to detect a memory leak?",
"answer": [
"State analysis",
"Coverage analysis",
"Dynamic analysis",
"Memory analysis"
],
"correct":"2"
},
{
"question":"Which of the following is NOT a standard related to testing?",
"answer": [
"IEEE829",
"IEEE610",
"BS7925-1",
"BS7925-2"
],
"correct":"1"
},
{
"question":"which of the following is the component test standard?",
"answer": [
"IEEE 829",
"IEEE 610",
"BS7925-1",
"BS7925-2"
],
"correct":"3"
},
{
"question":"which of the following statements are true?",
"answer": [
"Faults in program specifications are the most expensive to fix.",
"Faults in code are the most expensive to fix.",
"Faults in requirements are the most expensive to fix",
"Faults in designs are the most expensive to fix."
],
"correct":"2"
},
{
"question":"Which of the following is not the integration strategy?",
"answer": [
"Design based",
"Big-bang",
"Bottom-up",
"Top-down"
],
"correct":"0"
},
{
"question":"Which of the following is a black box design technique?",
"answer": [
"statement testing",
"equivalence partitioning",
"error- guessing",
"usability testing"
],
"correct":"1"
},
{
"question":"A program with high cyclometic complexity is almost likely to be:",
"answer": [
"Large",
"Small",
"Difficult to write",
"Difficult to test"
],
"correct":"3"
},
{
"question":"Which of the following is a static test?",
"answer": [
"code inspection",
"coverage analysis",
"usability assessment",
"installation test"
],
"correct":"0"
},
{
"question":"Which of the following is the odd one out?",
"answer": [
"white box",
"glass box",
"structural",
"functional"
],
"correct":"3"
},
{
"question":"A program validates a numeric field as follows:<br>values less than 10 are rejected, values between 10 and 21 are accepted, values greater than or equal to 22<br>are rejected<br>which of the following input values cover all of the equivalence partitions?",
"answer": [
"10,11,21",
"3,20,21",
"3,10,22",
"10,21,22"
],
"correct":"2"
},
{
"question":"Using the same specifications as question 29, which of the following covers the MOST boundary<br>values?",
"answer": [
"9,10,11,22",
"9,10,21,22",
"10,11,21,22",
"10,11,20,21"
],
"correct":"1"
},
{
"question":"An input field takes the year of birth between 1900 and 2004. The boundary values for testing<br>this field are",
"answer": [
"0,1900,2004,2005",
"1900, 2004",
"1899,1900,2004,2005",
"1899, 1900, 1901,2003,2004,2005"
],
"correct":"2"
},
{
"question":"Which one of the following are non-functional testing methods?",
"answer": [
"System testing",
"Usability testing",
"Performance testing",
"Both b and c"
],
"correct":"3"
},
{
"question":"Which of the following tools would be involved in the automation of regression test?",
"answer": [
"Data tester",
"Boundary tester",
"Capture/Playback",
"Output comparator."
],
"correct":"2"
},
{
"question":"Incorrect form of Logic coverage is:",
"answer": [
"Statement Coverage",
"Pole Coverage",
"Condition Coverage",
"Path Coverage"
],
"correct":"1"
},
{
"question":"Which of the following is not a quality characteristic listed in ISO 9126 Standard?",
"answer": [
"Functionality",
"Usability",
"Supportability",
"Maintainability"
],
"correct":"2"
},
{
"question":"To test a function, the programmer has to write a _________, which calls the function to be<br>tested and passes it test data.",
"answer": [
"Stub",
"Driver",
"Proxy",
"None of the above"
],
"correct":"1"
},
{
"question":"Acceptance test cases are based on what?",
"answer": [
"Requirements",
"Design",
"Code",
"Decision table"
],
"correct":"0"
},
{
"question":"A common test technique during component test is",
"answer": [
"Statement and branch testing",
"Usability testing",
"Security testing",
"Performance testing"
],
"correct":"0"
},
{
"question":"Statement Coverage will not check for the following.",
"answer": [
"Missing Statements",
"Unused Branches",
"Dead Code",
"Unused Statement"
],
"correct":"0"
},
{
"question":"One of the fields on a form contains a text box which accepts alphabets in lower or upper case.<br>Indentify the invalid Equivalance class value.",
"answer": [
"CLASS",
"cLASS",
"CLass",
"CLa01ss"
],
"correct":"3"
}

];
//--------------------------------------------------------
var paper2x =
     [
    {
      "question": "h testing is enough should take into\naccount :-</span></b></p>\n\n<p class=MsoNormal style='margin-bottom:0in;margin-bottom:.0001pt;line-height:\nnormal;text-autospace:none'><i><span lang=EN style='font-size:8.5pt;font-family:\n\"Verdana\\,Italic\"'>i. Level of Risk including Technical and Business product\nand project risk</span></i></p>\n\n<p class=MsoNormal ",
      "answer": [
        "paper2",
        "2gv",
        "ans3",
        "ans4"
      ],
      "correct": "2"
    },
    {
      "question": "this is question 2",
      "answer": [
        "paper2",
        "ans2",
        "ans3",
        "ans4"
      ],
      "correct": "1"
    },
    {
      "question": "this is question 3",
      "answer": [
        "paper2",
        "ans2",
        "ans3",
        "ans4"
      ],
      "correct": "1"
    },
    {
      "question": "this is question 4",
      "answer": [
        "paper2",
        "ans2",
        "ans3",
        "ans4"
      ],
      "correct": "0"
    },
    {
      "question": "this is question 5",
      "answer": [
        "paper2",
        "ans2",
        "ans3",
        "ans4"
      ],
      "correct": "3"
    }
  ]
;
//=============================== paper3

var paper3 = [
{
"question":"___________ Testing will be performed by the people at client own locations",
"answer": [
"Alpha testing",
"Field testing",
"Performance testing",
"System testing"
],
"correct":"1"
},
{
"question":"System testing should investigate",
"answer": [
"Non-functional requirements only not Functional requirements",
"Functional requirements only not non-functional requirements",
"Non-functional requirements and Functional requirements",
"Non-functional requirements or Functional requirements"
],
"correct":"2"
},
{
"question":"Which is the non-functional testing",
"answer": [
"Performance testing",
"Unit testing",
"Regression testing",
"Sanity testing"
],
"correct":"0"
},
{
"question":"Who is responsible for document all the issues, problems and open point that<br>were identified during the review meeting",
"answer": [
"Moderator",
"Scribe",
"Reviewers",
"Author"
],
"correct":"1"
},
{
"question":"What is the main purpose of Informal review",
"answer": [
"Inexpensive way to get some benefit",
"Find defects",
"Learning, gaining understanding, effect finding",
"Discuss, make decisions, solve technical problems"
],
"correct":"0"
},
{
"question":"Purpose of test design technique is",
"answer": [
"Identifying test conditions only, not Identifying test cases",
"Not Identifying test conditions, Identifying test cases only",
"Identifying test conditions and Identifying test cases",
"Identifying test conditions or Identifying test cases"
],
"correct":"2"
},
{
"question":"___________ technique can be used to achieve input and output coverage",
"answer": [
"Boundary value analysis",
"Equivalence partitioning",
"Decision table testing",
"State transition testing"
],
"correct":"1"
},
{
"question":"Use cases can be performed to test",
"answer": [
"Performance testing",
"Unit testing",
"Business scenarios",
"Static testing"
],
"correct":"2"
},
{
"question":"________________ testing is performed at the developing organization's site",
"answer": [
"Unit testing",
"Regression testing",
"Alpha testing",
"Integration testing"
],
"correct":"2"
},
{
"question":"The purpose of exit criteria is",
"answer": [
"Define when to stop testing",
"End of test level",
"When a set of tests has achieved a specific pre condition",
"All of the above"
],
"correct":"3"
},
{
"question":"Which is not the project risks",
"answer": [
"Supplier issues",
"Organization factors",
"Technical issues",
"Error-prone software delivered"
],
"correct":"3"
},
{
"question":"Poor software characteristics are",
"answer": [
"Only Project risks",
"Only Product risks",
"Project risks and Product risks",
"Project risks or Product risks"
],
"correct":"1"
},
{
"question":"________ and ________ are used within individual workbenches to produce<br>the right output products.",
"answer": [
"Tools and techniques",
"Procedures and standards",
"Processes and walkthroughs",
"Reviews and update"
],
"correct":"1"
},
{
"question":"The software engineer's role in tool selection is",
"answer": [
"To identify, evaluate, and rank tools, and recommend tools to management",
"To determine what kind of tool is needed, then find it and buy it",
"To initiate the tool search and present a case to management",
"To identify, evaluate and select the tools"
],
"correct":"0"
},
{
"question":"A _____ is the step-by-step method followed to ensure that standards are met",
"answer": [
"SDLC",
"Project Plan",
"Policy",
"Procedure"
],
"correct":"3"
},
{
"question":"Which of the following is the standard for the Software product quality",
"answer": [
"ISO 1926",
"ISO 829",
"ISO 1012",
"ISO 1028"
],
"correct":"0"
},
{
"question":"Which is not the testing objectives",
"answer": [
"Finding defects",
"Gaining confidence about the level of quality and providing information",
"Preventing defects.",
"Debugging defects"
],
"correct":"3"
},
{
"question":"Bug life cycle",
"answer": [
"Open, Assigned, Fixed, Closed",
"Open, Fixed, Assigned, Closed",
"Assigned, Open, Closed, Fixed",
"Assigned, Open, Fixed, Closed"
],
"correct":"0"
},
{
"question":"Which is not the software characteristics",
"answer": [
"Reliability",
"Usability",
"Scalability",
"Maintainability"
],
"correct":"2"
},
{
"question":"Which is not a testing principle",
"answer": [
"Early testing",
"Defect clustering",
"Pesticide paradox",
"Exhaustive testing"
],
"correct":"3"
},
{
"question":"'X' has given a data on a person age, which should be between 1 to 99. Using<br>BVA which is the appropriate one",
"answer": [
"0,1,2,99",
"1, 99, 100, 98",
"0, 1, 99, 100",
"-1, 0, 1, 99"
],
"correct":"2"
},
{
"question":"Which is not the fundamental test process",
"answer": [
"Planning and control",
"Test closure activities",
"Analysis and design",
"None"
],
"correct":"3"
},
{
"question":"Which is not a Component testing",
"answer": [
"Check the memory leaks",
"Check the robustness",
"Check the branch coverage",
"Check the decision tables"
],
"correct":"3"
},
{
"question":"PDCA is known as",
"answer": [
"Plan, Do, Check, Act",
"Plan, Do, Correct, Act",
"Plan, Debug, Check, Act",
"Plan, Do, Check, Accept"
],
"correct":"0"
},
{
"question":"Contract and regulation testing is a part of",
"answer": [
"System testing",
"Acceptance testing",
"Integration testing",
"Smoke testing"
],
"correct":"1"
},
{
"question":"Which is not a black box testing technique",
"answer": [
"Equivalence partition",
"Decision tables",
"Transaction diagrams",
"Decision testing"
],
"correct":"3"
},
{
"question":"Arc testing is known as",
"answer": [
"Branch testing",
"Agile testing",
"Beta testing",
"Ad-hoc testing"
],
"correct":"0"
},
{
"question":"A software model that can't be used in functional testing",
"answer": [
"Process flow model",
"State transaction model",
"Menu structure model",
"Plain language specification model"
],
"correct":"2"
},
{
"question":"Find the mismatch",
"answer": [
"Test data preparation tools - Manipulate Data bases",
"Test design tools - Generate test inputs",
"Requirement management tools - Enables individual tests to be traceable",
"Configuration management tools - Check for consistence"
],
"correct":"3"
},
{
"question":"The principle of Cyclomatic complexity, considering L as edges or links, N as<br>nodes, P as independent paths",
"answer": [
"L-N +2P",
"N-L +2P",
"N-L +P",
"N-L +P"
],
"correct":"0"
},
{
"question":"FPA is used to",
"answer": [
"To measure the functional requirements of the project",
"To measure the size of the functionality of an Information system",
"To measure the functional testing effort",
"To measure the functional flow"
],
"correct":"1"
},
{
"question":"Which is not a test Oracle",
"answer": [
"The existing system (For a bench mark)",
"The code",
"Individual's knowledge",
"User manual"
],
"correct":"1"
},
{
"question":"Find the correct flow of the phases of a formal review",
"answer": [
"Planning, Review meeting, Rework, Kick off",
"Planning, Individual preparation, Kick off, Rework",
"Planning, Review meeting, Rework, Follow up",
"Planning, Individual preparation, Follow up, Kick off"
],
"correct":"2"
},
{
"question":"Stochastic testing using statistical information or operational profiles uses<br>the following method",
"answer": [
"Heuristic testing approach",
"Methodical testing approach",
"Model based testing approach",
"Process or standard compliant testing approach"
],
"correct":"2"
},
{
"question":"A project that is in the implementation phase is six weeks behind schedule.<br>The delivery date for the product is four months away. The project is not allowed<br>to slip the delivery date or compromise on the quality standards established for<br>this product. Wh",
"answer": [
"Eliminate some of the requirements that have not yet been implemented.",
"Add more engineers to the project to make up for lost work.",
"Ask the current developers to work overtime until the lost work is recovered.",
"Hire more software quality assurance personnel."
],
"correct":"0"
},
{
"question":"One person has been dominating the current software process improvement<br>meeting. Which of the following techniques should the facilitator use to bring<br>other team members into the discussion?",
"answer": [
"Confront the person and ask that other team members be allowed to express their<br>opinions.",
"Wait for the person to pause, acknowledge the person' s opinion, and ask for<br>someone else' s opinion.",
"Switch the topic to an issue about which the person does not have a strong opinion.",
"Express an opinion that differs from the person' s opinion in order to encourage<br>others to express their ideas."
],
"correct":"1"
},
{
"question":"Maintenance releases and technical assistance centers are examples of which<br>of the following costs of quality?",
"answer": [
"External failure",
"Internal failure",
"Appraisal",
"Prevention"
],
"correct":"0"
},
{
"question":"Deciding How much testing is enough should take into account :-<br>i. Level of Risk including Technical and Business product and project risk<br>ii. Project constraints such as time and budget<br>iii. Size of Testing Team<br>iv. Size of the Development Team",
"answer": [
"i,ii,iii are true and iv is false",
"i,,iv are true and ii is false",
"i,ii are true and iii,iv are false",
"ii,iii,iv are true and i is false"
],
"correct":"2"
},
{
"question":"Test planning has which of the following major tasks?<br>i. Determining the scope and risks, and identifying the objectives of testing.<br>ii. Determining the test approach (techniques,test items, coverage, identifying and interfacing the teams involved in testing , testware)<br>iii. Reviewing the Test Basis (such as requirements,architecture,design,interface)<br>iv. Determining the exit criteria.<br>",
"answer": [
"i,ii,iv are true and iii is false",
"i,,iv are true and ii is false",
"i,ii are true and iii,iv are false",
"ii,iii,iv are true and i is false"
],
"correct":"0"
},
{
"question":"Evaluating testability of the requirements and system are a part of which phase:-",
"answer": [
"Test Analysis and Design",
"Test Planning and control",
"Test Implementation and execution",
"Evaluating exit criteria and reporting"
],
"correct":"0"
}

];

// =============== paper4 
var paper4 = [

{
"question":"One of the fields on a form contains a text box which accepts numeric values in the range of<br>18 to 25. Identify the invalid Equivalance class",
"answer": [
"17",
"19",
"24",
"21"
],
"correct":"0"
},
{
"question":"Exhaustive Testing is",
"answer": [
"Is impractical but possible",
"Is practically possible",
"Is impractical and impossible",
"Is always possible"
],
"correct":"0"
},
{
"question":"Hand over of Testware is a part of which Phase",
"answer": [
"Test Analysis and Design",
"Test Planning and control",
"Test Closure Activities",
"Evaluating exit criteria and reporting"
],
"correct":"0"
},
{
"question":"Which one is not comes under international standard",
"answer": [
"IEC",
"IEEE",
"ISO",
"All of the above"
],
"correct":"2"
},
{
"question":"In which phase static tests are used",
"answer": [
"Requirements",
"Design",
"Coding",
"All of the above"
],
"correct":"1"
},
{
"question":"What's the disadvantage of Black Box Testing",
"answer": [
"Chances of having repetition of tests that are already done by programmer.",
"The test inputs needs to be from large sample space.",
"It is difficult to identify all possible inputs in limited testing time. So writing test cases is<br>slow and difficult",
"All above"
],
"correct":"3"
},
{
"question":"Static analysis tools are typically used by",
"answer": [
"Testers",
"Developers",
"Testers and Developers",
"None"
],
"correct":"3"
},
{
"question":"Majority of system errors occur in the __________ phase",
"answer": [
"Requirements Phase.",
"Analysis and Design Phase",
"Development Phase",
"Testing Phase"
],
"correct":"1"
},
{
"question":"The specification which describes steps required to operate the system and exercise test<br>cases in order to implement the associated test design",
"answer": [
"Test Case Specification",
"Test Design Specification",
"Test Procedure Specification",
"None"
],
"correct":"0"
},
{
"question":"How much percentage of the life cycle costs of a software are spent on maintenance.",
"answer": [
"10%",
"30%",
"50%",
"70%"
],
"correct":"2"
},
{
"question":"When a defect is detected and fixed then the software should be retested to confirm that<br>the original defect has been successfully removed. This is called",
"answer": [
"Regression testing",
"Maintenance testing",
"Confirmation testing",
"None of the above"
],
"correct":"3"
},
{
"question":"When to stop Testing?",
"answer": [
"Stop when scheduled time for testing expires",
"Stop if 75% of the pre-defined number of errors is detected.",
"Stop when all the test cases execute with detecting few errors.",
"None above"
],
"correct":"2"
},
{
"question":"Structure is unknown for which type of development project",
"answer": [
"Traditional system development",
"Iterative development",
"System maintenance",
"Purchased/contracted software"
],
"correct":"0"
},
{
"question":"__________ indicates how important it is to fix the bug and when it should be fixed",
"answer": [
"Severity",
"Priority",
"All of the above",
"None of the above"
],
"correct":"3"
},
{
"question":"The person who leads the review of the document(s), planning the review,running the<br>meeting and follow-up after the meeting",
"answer": [
"Reviewer",
"Author",
"Moderator",
"Auditor"
],
"correct":"2"
},
{
"question":"Performs sufficient testing to evaluate every possible path and condition in the application<br>system. The only test method that guarantees the proper functioning of the application system is<br>called as __________",
"answer": [
"Regression Testing",
"Exhaustive Testing",
"Basic Path Testing",
"Branch Testing"
],
"correct":"2"
},
{
"question":"A formal assessment of a work product conducted by one or more qualified independent<br>reviewer to detect defects.",
"answer": [
"Inspection.",
"Walkthrough.",
"Review",
"Non Conformance"
],
"correct":"2"
},
{
"question":"Test Case are grouped into Manageable (and scheduled) units are called as",
"answer": [
"Test Harness",
"Test Suite",
"Test Cycle",
"Test Driver"
],
"correct":"0"
},
{
"question":"What type of tools to be used for Regression Testing",
"answer": [
"Performance",
"Record/Playback",
"A and B",
"None"
],
"correct":"1"
},
{
"question":"System Integration testing should be done after",
"answer": [
"Integration testing",
"System testing",
"Unit testing",
"Component integration testing"
],
"correct":"1"
},
{
"question":"During this event the entire system is tested to verify that all functional information structural and quality requirements have been met. A predetermined combination of tests is<br>designed that when executed successfully satisfy management that the system ",
"answer": [
"Validation Testing",
"Integration Testing",
"User Acceptance Testing",
"System Testing"
],
"correct":"2"
},
{
"question":"What is the normal order of activities in which software testing is organized?",
"answer": [
"Unit, integration, system, validation",
"System, integration, unit, validation",
"Unit, integration, validation, system",
"None of the above"
],
"correct":"2"
},
{
"question":"The principal attributes of tools and automation are",
"answer": [
"Speed and efficiency",
"Accuracy and precision",
"All of the above",
"None of the above"
],
"correct":"0"
},
{
"question":"In __________ testing doesn't know anything about the sofware being tested; it just clicks or<br>types randomly.",
"answer": [
"Random testing",
"Gorilla testing",
"Adhoc testing",
"Dumb monkey testing"
],
"correct":"2"
},
{
"question":"A series of probing questions about the completeness and attributes of an application system<br>is called",
"answer": [
"Checklist",
"Checkpoint review",
"Decision table",
"Decision tree"
],
"correct":"3"
},
{
"question":"The testing technique that requires devising test cases to demonstrate that each program<br>function is operational is called",
"answer": [
"Black-box testing",
"Glass-box testing",
"Grey-box testing",
"White-box testing"
],
"correct":"0"
},
{
"question":"A white box testing technique that measures the number of or percentage of decision<br>directions executed by the test case designed is called",
"answer": [
"Condition coverage",
"Decision/Condition coverage",
"Decision Coverage",
"Branch coverage"
],
"correct":"2"
},
{
"question":"Which summarizes the testing activities associated with one or more test design<br>specifications.",
"answer": [
"Test Summary report",
"Test Log",
"Test Incident Report",
"Test Script"
],
"correct":"1"
},
{
"question":"Testing without a real plan and test cases is called ---",
"answer": [
"Gorilla testing",
"Monkey testing",
"Adhoc testing",
"All of the above"
],
"correct":"2"
},
{
"question":"Which rule should not be followed for reviews",
"answer": [
"Defects and issues are identified and corrected",
"The product is reviewed not the producer",
"All members of the reviewing team are responsible for the result of the review",
"Each review has a clear predefined objective"
],
"correct":"3"
},
{
"question":"Which testing is used to verify that the system can perform properly when internal program<br>or system limitations have been exceeded",
"answer": [
"Stress Testing",
"Load Testing",
"Performance Testing",
"Volume testing"
],
"correct":"2"
},
{
"question":"In a system designed to work out the tax to be paid:<br>An employee has £4000 of salary tax free. The next £1500 is taxed at 10% The next £28000 is<br>taxed at 22% Any further amount is taxed at 40% Which of these groups of numbers would fall<br>into the same equi",
"answer": [
"£4800; £14000; £28000",
"£5200; £5500; £28000",
"£28001; £32000; £35000",
"£5800; £28000; £32000"
],
"correct":"3"
},
{
"question":"Which of the following has highest level of independence in which test cases are :",
"answer": [
"Designed by persons who write the software under test",
"Designed by a person from a different section",
"Designed by a person from a different organization",
"Designed by another person"
],
"correct":"2"
},
{
"question":"We use the output of the requirement analysis, the requirement specification as the input for<br>writing :-",
"answer": [
"User Acceptance Test Cases",
"Integration Level Test Cases",
"Unit Level Test Cases",
"Program specifications"
],
"correct":"0"
},
{
"question":"Validation involves which of the following<br>i. Helps to check the Quality of the Built Product<br>ii. Helps to check that we have built the right product.<br>iii. Helps in developing the product<br>iv. Monitoring tool wastage and obsoleteness.",
"answer": [
"Options i,ii,iii,iv are true.",
"ii is true and i,iii,iv are false",
"i,ii,iii are true and iv is false",
"iii is true and i,ii,iv are false."
],
"correct":"1"
},
{
"question":"Which of the following uses Impact Analysis most?",
"answer": [
"Component testing",
"Non-functional system testing",
"User acceptance testing",
"Maintenance testing"
],
"correct":"3"
},
{
"question":"Repeated Testing of an already tested program, after modification, to discover any defects<br>introduced or uncovered as a result of the changes in the software being tested or in another<br>related or unrelated software component:",
"answer": [
"Re Testing .",
"Confirmation Testing",
"Regression Testing",
"Negative Testing"
],
"correct":"2"
},
{
"question":"Impact Analysis helps to decide :-",
"answer": [
"How much regression testing should be done.",
"Exit Criteria",
"How many more test cases need to written.",
"Different Tools to perform Regression Testing"
],
"correct":"0"
},
{
"question":"Functional system testing is:",
"answer": [
"testing that the system functions with other systems",
"testing that the components that comprise the system function together",
"testing the end to end functionality of the system as a whole",
"testing the system performs functions within specified response times"
],
"correct":"2"
},
{
"question":"Peer Reviews are also called as :-",
"answer": [
"Inspection",
"Walkthrough",
"Technical Review",
"Formal Review"
],
"correct":"2"
}
];

//======================
//-------------------------------------
var myvar = '{'+
'	"questions":['+
'		{'+
'			"question":"Deciding How much testing is enough should take into account :- \ni. '+
''+
'Level of Risk including Technical and Business product and project risk \nii. Project constraints such as time and '+
''+
'budget \niii. Size of Testing Team \niv. Size of the Development Team \n",'+
'			"answer":['+
'				"i,ii,iii are true and iv is false",'+
'				"Project constraints such as time and budget",'+
'				"Size of Testing Team",'+
'				"Size of the Development Team"'+
'			],'+
'			"correct":"2"'+
'		},'+
'		{'+
'			"question":"this is question 2",'+
'			"answer":['+
'				"ans1",'+
'				"ans2",'+
'				"ans3",'+
'				"ans4"'+
'			],'+
'			"correct":"1"'+
'		},'+
'		{'+
'			"question":"this is question 3",'+
'			"answer":['+
'				"ans1",'+
'				"ans2",'+
'				"ans3",'+
'				"ans4"'+
'			],'+
'			"correct":"1"'+
'		},'+
'		{'+
'			"question":"this is question 4",'+
'			"answer":['+
'				"ans1",'+
'				"ans2",'+
'				"ans3",'+
'				"ans4"'+
'			],'+
'			"correct":"0"'+
'		},'+
'		{'+
'			"question":"this is question 5",'+
'			"answer":['+
'				"ans1",'+
'				"ans2",'+
'				"ans3",'+
'				"ans4"'+
'			],'+
'			"correct":"3"'+
'		}'+
'	]'+
'}';

//------------]
var paper2 = [
{
"question":"When what is visible to end-users is a deviation from the specific or expected behavior, this is<br>called:",
"answer": [
"an error",
"a fault",
"a failure",
"a defect"
],
"correct":"2"
},
{
"question":"Regression testing should be performed:<br>v) every week<br>w) after the software has changed<br>x) as often as possible<br>y) when the environment has changed<br>z) when the project manager says",
"answer": [
"v and w are true, x – z are false",
"w, x and y are true, v and z are false",
"w and y are true, v, x and z are false",
"w is true, v, x y and z are false"
],
"correct":"2"
},
{
"question":"IEEE 829 test plan documentation standard contains all of the following except:",
"answer": [
"test items",
"test deliverables",
"test tasks",
"test specification"
],
"correct":"4"
},
{
"question":"Testing should be stopped when:",
"answer": [
"all the planned tests have been run",
"time has run out",
"all faults have been fixed correctly",
"it depends on the risks for the system being tested"
],
"correct":"3"
},
{
"question":"Order numbers on a stock control system can range between 10000 and 99999 inclusive. Which<br>of the following inputs might be a result of designing tests for only valid equivalence classes and<br>valid boundaries:",
"answer": [
"1000, 5000, 99999",
"9999, 50000, 100000",
"10000, 50000, 99999",
"10000, 99999"
],
"correct":"2"
},
{
"question":"Consider the following statements about early test design:<br>i. early test design can prevent fault multiplication<br>ii. faults found during early test design are more expensive to fix<br>iii. early test design can find faults<br>iv. early test design can cause cha",
"answer": [
"i, iii and iv are true. Ii and v are false",
"iii is true, I, ii, iv and v are false",
"iii and iv are true. i, ii and v are false",
"i, iii, iv and v are true, ii us false"
],
"correct":"0"
},
{
"question":"Non-functional system testing includes:",
"answer": [
"testing to see where the system does not function properly",
"testing quality attributes of the system including performance and usability",
"testing a system feature using only the software required for that action",
"testing a system feature using only the software required for that function"
],
"correct":"1"
},
{
"question":"Which of the following is NOT part of configuration management:",
"answer": [
"status accounting of configuration items",
"auditing conformance to ISO9001",
"identification of test versions",
"record of changes to documentation over time"
],
"correct":"1"
},
{
"question":"Which of the following is the main purpose of the integration strategy for integration testing in<br>the small?",
"answer": [
"to ensure that all of the small modules are tested adequately",
"to ensure that the system interfaces to other systems and networks",
"to specify which modules to combine when and how many at once",
"to ensure that the integration testing can be performed by a small team"
],
"correct":"2"
},
{
"question":"What is the purpose of test completion criteria in a test plan:",
"answer": [
"to know when a specific test has finished its execution",
"to ensure that the test case specification is complete",
"to set the criteria used in generating test inputs",
"to plan when to stop testing"
],
"correct":"3"
},
{
"question":"Consider the following statements<br>i. an incident may be closed without being fixed<br>ii. incidents may not be raised against documentation<br>iii. the final stage of incident tracking is fixing<br>iv. the incident record does not include information on test envir",
"answer": [
"ii and v are true, I, iii and iv are false",
"i and v are true, ii, iii and iv are false",
"i, iv and v are true, ii and iii are false",
"i and ii are true, iii, iv and v are false"
],
"correct":"1"
},
{
"question":"Given the following code, which is true about the minimum number of test cases required for<br>full statement and branch coverage:<br>Read P<br>Read Q<br>IF P+Q > 100 THEN<br>Print “Large”<br>ENDIF<br>If P > 50 THEN<br>Print “P Large”<br>ENDIF",
"answer": [
"1 test for statement coverage, 3 for branch coverage",
"1 test for statement coverage, 2 for branch coverage",
"1 test for statement coverage, 1 for branch coverage",
"2 tests for statement coverage, 3 for branch coverage"
],
"correct":"1"
},
{
"question":"Given the following:<br>Switch PC on<br>Start “outlook”<br>IF outlook appears THEN<br>Send an email<br>Close outlook",
"answer": [
"1 test for statement coverage, 1 for branch coverage",
"1 test for statement coverage, 2 for branch coverage",
"1 test for statement coverage. 3 for branch coverage",
"2 tests for statement coverage, 2 for branch coverage"
],
"correct":"1"
},
{
"question":"Given the following code, which is true:<br>IF A > B THEN<br>C = A – B<br>ELSE<br>C = A + B<br>ENDIF<br>Read D<br>IF C = D Then<br>Print “Error”<br>ENDIF",
"answer": [
"1 test for statement coverage, 3 for branch coverage",
"2 tests for statement coverage, 2 for branch coverage",
"2 tests for statement coverage. 3 for branch coverage",
"3 tests for statement coverage, 3 for branch coverage"
],
"correct":"1"
},
{
"question":"Consider the following:<br>Pick up and read the newspaper<br>Look at what is on television<br>If there is a program that you are interested in watching then switch the the television on and watch the<br>program<br>Otherwise<br>Continue reading the newspaper<br>If there is a c",
"answer": [
"SC = 1 and DC = 1",
"SC = 1 and DC = 2",
"SC = 1 and DC = 3",
"SC = 2 and DC = 3"
],
"correct":"3"
},
{
"question":"The place to start if you want a (new) test tool is:",
"answer": [
"Attend a tool exhibition",
"Invite a vendor to give a demo",
"Analyse your needs and requirements",
"Find out what your budget would be for the tool"
],
"correct":"2"
},
{
"question":"When a new testing tool is purchased, it should be used first by:",
"answer": [
"A small team to establish the best way to use the tool",
"Everyone who may eventually have some use for the tool",
"The independent testing team",
"The managers to see what projects it should be used in"
],
"correct":"1"
},
{
"question":"What can static analysis NOT find?",
"answer": [
"The use of a variable before it has been defined",
"Unreachable (“dead”) code",
"Whether the value stored in a variable is correct",
"The re-definition of a variable before it has been used"
],
"correct":"2"
},
{
"question":"Which of the following is NOT a black box technique:",
"answer": [
"Equivalence partitioning",
"State transition testing",
"LCSAJ",
"Syntax testing"
],
"correct":"2"
},
{
"question":"Beta testing is:",
"answer": [
"Performed by customers at their own site",
"Performed by customers at their software developer’s site",
"Performed by an independent test team",
"Useful to test bespoke software"
],
"correct":"0"
},
{
"question":"Given the following types of tool, which tools would typically be used by developers and which<br>by an independent test team:<br>i. static analysis<br>ii. performance testing<br>iii. test management<br>iv. dynamic analysis<br>v. test running<br>vi. test data preparation",
"answer": [
"developers would typically use i, iv and vi; test team ii, iii and v",
"developers would typically use i and iv; test team ii, iii, v and vi",
"developers would typically use i, ii, iii and iv; test team v and vi",
"developers would typically use ii, iv and vi; test team I, ii and v"
],
"correct":"1"
},
{
"question":"The main focus of acceptance testing is:",
"answer": [
"finding faults in the system",
"ensuring that the system is acceptable to all users",
"testing the system with other systems",
"testing for a business perspective"
],
"correct":"3"
},
{
"question":"Which of the following statements about the component testing standard is false:",
"answer": [
"black box design techniques all have an associated measurement technique",
"white box design techniques all have an associated measurement technique",
"cyclomatic complexity is not a test measurement technique",
"black box measurement techniques all have an associated test design technique"
],
"correct":"0"
},
{
"question":"Which of the following statements is NOT true:",
"answer": [
"inspection is the most formal review process",
"inspections should be led by a trained leader",
"managers can perform inspections on management documents",
"inspection is appropriate even when there are no written documents"
],
"correct":"3"
},
{
"question":"A typical commercial test execution tool would be able to perform all of the following EXCEPT:",
"answer": [
"generating expected outputs",
"replaying inputs according to a programmed script",
"comparison of expected outcomes with actual outcomes",
"recording test inputs"
],
"correct":"0"
},
{
"question":"The difference between re-testing and regression testing is",
"answer": [
"re-testing is running a test again; regression testing looks for unexpected side effects",
"re-testing looks for unexpected side effects; regression testing is repeating those tests",
"re-testing is done after faults are fixed; regression testing is done earlier",
"re-testing uses different environments, regression testing uses the same environment"
],
"correct":"0"
},
{
"question":"Expected results are:",
"answer": [
"only important in system testing",
"only used in component testing",
"never specified in advance",
"most useful when specified in advance"
],
"correct":"3"
},
{
"question":"Test managers should not:",
"answer": [
"report on deviations from the project plan",
"sign the system off for release",
"re-allocate resource to meet original plans",
"raise incidents on faults that they have found"
],
"correct":"2"
},
{
"question":"Unreachable code would best be found using:",
"answer": [
"code reviews",
"code inspections",
"a coverage tool",
"a static analysis tool"
],
"correct":"3"
},
{
"question":"A tool that supports traceability, recording of incidents or scheduling of tests is called:",
"answer": [
"a dynamic analysis tool",
"a test execution tool",
"a debugging tool",
"a test management tool"
],
"correct":"3"
},
{
"question":"What information need not be included in a test incident report:",
"answer": [
"how to fix the fault",
"how to reproduce the fault",
"test environment details",
"severity, priority"
],
"correct":"0"
},
{
"question":"Which expression best matches the following characteristics or review processes:<br>1. led by author<br>2. undocumented<br>3. no management participation<br>4. led by a trained moderator or leader<br>5. uses entry exit criteria<br>s) inspection<br>t) peer review<br>u) informal r",
"answer": [
"s = 4, t = 3, u = 2 and 5, v = 1",
"s = 4 and 5, t = 3, u = 2, v = 1",
"s = 1 and 5, t = 3, u = 2, v = 4",
"s = 5, t = 4, u = 3, v = 1 and 2"
],
"correct":"1"
},
{
"question":"Which of the following is NOT part of system testing:",
"answer": [
"business process-based testing",
"performance, load and stress testing",
"requirements-based testing",
"top-down integration testing"
],
"correct":"3"
},
{
"question":"What statement about expected outcomes is FALSE:",
"answer": [
"expected outcomes are defined by the software’s behaviour",
"expected outcomes are derived from a specification, not from the code",
"expected outcomes include outputs to a screen and changes to files and databases",
"expected outcomes should be predicted before a test is run"
],
"correct":"0"
},
{
"question":"The standard that gives definitions of testing terms is:",
"answer": [
"ISO/IEC 12207",
"BS7925-1",
"BS7925-2",
"ANSI/IEEE 829"
],
"correct":"1"
},
{
"question":"The cost of fixing a fault:",
"answer": [
"Is not important",
"Increases as we move the product towards live use",
"Decreases as we move the product towards live use",
"Is more expensive if found in requirements than functional design"
],
"correct":"1"
},
{
"question":"Which of the following is NOT included in the Test Plan document of the Test Documentation<br>Standard:",
"answer": [
"Test items (i.e. software versions)",
"What is not to be tested",
"Test environments",
"Quality plans"
],
"correct":"3"
},
{
"question":"Could reviews or inspections be considered part of testing:",
"answer": [
"No, because they apply to development documentation",
"No, because they are normally applied before testing",
"No, because they do not apply to the test documentation",
"Yes, because both help detect faults and improve quality"
],
"correct":"3"
},
{
"question":"Which of the following is not part of performance testing:",
"answer": [
"Measuring response time",
"Measuring transaction rates",
"Recovery testing",
"Simulating many users"
],
"correct":"2"
},
{
"question":"Error guessing is best used",
"answer": [
"As the first approach to deriving test cases",
"After more formal techniques have been applied",
"By inexperienced testers",
"After the system has gone live"
],
"correct":"1"
}
];	



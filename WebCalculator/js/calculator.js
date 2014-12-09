var resultsTextbox;

function doclick(elem) {
    resultsTextbox = document.getElementById("results");
    var elemVal = elem.id;

    switch (elemVal) {
    case '=':
        updateResultTB('=');
        calculate();
        break;

    case 'C':
        backspaceResultTB();
        break;

    case 'A':
        clearResultTB();
        updateResultTB('0');
        break;

    default:
        if (getResultTB() === "ERROR")
            clearResultTB();
        updateResultTB(elemVal);
        break;
    }
};

function getResultTB() {
    return resultsTextbox.innerHTML.trim();
};

function updateResultTB(val) {
    if (getResultTB() == "0")
        resultsTextbox.innerHTML = val;
    else resultsTextbox.innerHTML += val;
};

function clearResultTB() {
    resultsTextbox.innerHTML = "";
};

function backspaceResultTB() {
    if (resultsTextbox.innerHTML.trim().length == 1 || resultsTextbox.innerHTML.trim() == "ERROR")
        resultsTextbox.innerHTML = '0';
    else {
        resultsTextbox.innerHTML = resultsTextbox.innerHTML.trim().substring(0, resultsTextbox.innerHTML.length - 1);
    }
};

function isOperator(c) {
    if (c == "+" || c == "-" || c == "/" || c == "*" || c == "=")
        return true;
    return false;
};

function operationAction(total, num, operator) {
    ntotal = parseFloat(total);
    switch (operator) {
    case '+':
        ntotal += parseFloat(num);
        break;

    case '-':
        ntotal -= parseFloat(num);
        break;

    case '*':
        ntotal *= parseFloat(num);
        break;

    case '/':
        if (parseFloat(num) === 0)
            return "ERROR";
        ntotal /= parseFloat(num);
        break;
    }
    return ntotal;
};

function calculate() {
    var c, num = new String();
    var total = 0.0;
    var firstnum = true;
    var lastoperator = '+';
    for (var i = 0; i < resultsTextbox.innerHTML.length; i++) {
        c = resultsTextbox.innerHTML[i];
        if (isOperator(c)) {
            if (firstnum) {
                total = num;
                firstnum = false;
                num = "";
                lastoperator = c;
            } else {
                total = operationAction(total, num, lastoperator);
                lastoperator = c;
                num = "";
            }
        } else num = num.concat(c);
    }

    clearResultTB();
    updateResultTB(total);
};
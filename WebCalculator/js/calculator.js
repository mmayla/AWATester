var lastopr = "+";
var total = 0;
var resultsTextbox;
var lastNum;

function init() {
    lastopr = "+";
    total = 0;
    lastNum = '';
}

function doclick(elem) {
    resultsTextbox = document.getElementById("results");
    var elemVal = elem.innerHTML;

    if ((elemVal >= 0 && elemVal <= 9) || (elemVal == ".")) {
        lastNum += elemVal;
        updateResultTB(elemVal);
    } else {
        switch (elemVal) {
        case 'C':
            //lastNum = lastNum.substring(0, lastNum.length - 1);
            break;
        case 'AC':
            total = 0;
            resultsTextbox.innerHTML = 0;
            break;
        case '=':
            calculate(lastopr);
            resultsTextbox.innerHTML = total;
            //total = 0;
            break;
        default:
            calculate(elemVal);
            break;
        }
        lastNum = '';
        console.log(">>" + total);
    }

    //resultsTextbox.innerHTML = resultsTextbox.innerHTML+" "+elem.innerHTML;
};

function updateResultTB(val) {
    if (resultsTextbox.innerHTML.trim() == "0")
        resultsTextbox.innerHTML = val;
    else resultsTextbox.innerHTML += val;
};

function calculate(operation) {
    if(lastNum=='') {
        lastopr=operation;
        updateResultTB(operation);
    }
    else
    switch (operation) {
    case '+':
        total += parseFloat(lastNum, 10);
        updateResultTB(operation);
        break;
    case '-':
        total -= parseFloat(lastNum);
        updateResultTB(operation);
        break;
    case '*':
        total *= parseFloat(lastNum);
        updateResultTB(operation);
        break;
    case '/':
        total /= parseFloat(lastNum);
        updateResultTB(operation);
    }
    lastopr = operation;
};
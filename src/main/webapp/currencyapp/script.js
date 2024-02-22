document.addEventListener('DOMContentLoaded', function () {
    var form = document.getElementById('currencyForm');
    form.onsubmit = function (e) {
        e.preventDefault();

        var value = document.getElementById('money').value;
        var exchangeType = document.querySelector('input[name="exchange"]:checked').value;

        fetch('/app/convert?value=' + value + '&exchange=' + exchangeType)
            .then(function (response) {
                if (!response.ok) {
                    throw new Error('Server returned an error response');
                }
                return response.json();
            })
            .then(function (data) {
                var symbol = data.targetCurrencySymbol; // Zmieniono z getCurrencySymbol, które nie jest potrzebne
                document.getElementById('result').textContent = 'Result: ' + data.result + ' ' + symbol;
            })
            .catch(function (error) {
                console.error('Error:', error);
                document.getElementById('result').textContent = 'Error: ' + error.message;
            });
    };
});

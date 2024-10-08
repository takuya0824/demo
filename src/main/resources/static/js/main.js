// すべてのラジオボタンを取得
const radios = document.querySelectorAll('input[name="custom-radio"]');
// error-areaクラスを持つdiv要素を取得
const errorArea = document.querySelector('.error-area');
// 新しい<p>タグを作成
const pElement = document.createElement('p');
let season = null;

// 各ラジオボタンにイベントリスナーを追加
radios.forEach(radio => {
    radio.addEventListener('change', function() {
        // APIに必要な季節のデータを格納
        season = this.value;
    });
});

function execGacha() {
  $.ajax({
    type: 'POST',
    url: 'http://localhost:8080/gacha/coordinate',
    data: JSON.stringify({ season: season }),
    contentType: 'application/json',
    dataType: 'json'
  })
  //↓フォームの送信に成功した場合の処理
  .done(function(data) {
    console.log(data);
    if (errorArea.childNodes.length > 0) {
      errorArea.removeChild(pElement);
    }
  })
  //↓フォームの送信に失敗した場合の処理
  .fail(function(e) {
    if (errorArea.childNodes.length > 0) {
      errorArea.removeChild(pElement);
    }
    // pタグにテキストを設定
    pElement.textContent = e.responseJSON.message;

    // 作成したpタグをerror-areaに追加
    errorArea.appendChild(pElement);
  });
}
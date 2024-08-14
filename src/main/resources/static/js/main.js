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
        // 選択されたラジオボタンのvalueをコンソールに表示
        console.log(this.value);
        // APIに必要な季節のデータを格納
        season = this.value;
    });
});

function execGacha() {
  $.ajax({
    type: 'GET',
    url: 'http://localhost:8080/gacha/coordinate',
    data: { season: season },
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
    console.log(e.responseJSON.message);
    if (errorArea.childNodes.length > 0) {
      errorArea.removeChild(pElement);
    }
    // pタグにテキストを設定
    pElement.textContent = e.responseJSON.message;

    // 作成したpタグをerror-areaに追加
    errorArea.appendChild(pElement);
  });
}
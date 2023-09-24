// 学習の用途でこのjsが邪魔になる場合読み飛ばしてください。

/**
 * 画面のボタンにハンドラを設定
 */
function set_btn_handler() {
  // 検索ボタン
  document.getElementById("search").addEventListener("click", meet_search);
}

/**
 * 検索ボタン実行時
 */
function meet_search() {
  // 実際はこんなことしません。動いているように見せるためにしています。
  const res_id = document.getElementById("res_id").value;
  const res_name = document.getElementById("res_name").value;
  const res_status = document.getElementById("res_status").value;

  // 各種エレメント取得
  let meet_1 = document.getElementById("meet_1");
  let meet_2 = document.getElementById("meet_2");
  let meet_3 = document.getElementById("meet_3");

  // 文字列が含まれているか確認し、表示、非表示をクラス付与、削除にて設定
  if("000001".includes(res_id) &&
  "イノベーショングループ会議".includes(res_name) &&
  document.getElementById("meet_1_status").textContent.includes(res_status)){
    meet_1.classList.remove("display_none");
  } else {
    meet_1.classList.add("display_none");
  }

  // 文字列が含まれているか確認し、もしくは一致しているか確認し、表示、非表示をクラス付与、削除にて設定
  if("000002".includes(res_id) &&
  "打ち合わせ（仮）".includes(res_name) &&
  document.getElementById("meet_2_status").textContent.includes(res_status)){
    meet_2.classList.remove("display_none");
  } else {
    meet_2.classList.add("display_none");
  }

  // 文字列が含まれているか確認し、表示、非表示をクラス付与、削除にて設定
  if("000003".includes(res_id) &&
  "俺の予約".includes(res_name) &&
  document.getElementById("meet_3_status").textContent.includes(res_status)){
    meet_3.classList.remove("display_none");
  } else {
    meet_3.classList.add("display_none");
  }
}

/**
 * 予約ボタン押したときの動作
 */
function reservation_button(event) {
  // 対象の番号をIDから取得
  const id_split_array = event.id.split("_");
  // ボタンを無効
  event.disabled = true

  // ボタンを有効
  document.getElementById("meet_" + id_split_array[1] +"_cancel").disabled = false

  // 文字を変更
  document.getElementById("meet_" + id_split_array[1] +"_status").innerHTML = "予約中";
}

/**
 * キャンセルボタン押したときの動作
 */
function cancel_button(event) {
  // 対象の番号をIDから取得
  const id_split_array = event.id.split("_");
  // ボタンを無効
  event.disabled = true

  // ボタンを有効
  document.getElementById("meet_" + id_split_array[1] +"_reservation").disabled = false

  // 文字を変更
  document.getElementById("meet_" + id_split_array[1] +"_status").innerHTML = "キャンセル";
}

// 画面読み込み時
window.onload = function () {
  // 設定画面のボタンにハンドラを設定
  set_btn_handler();
};
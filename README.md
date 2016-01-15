# polling
ポーリングの動作確認用アプリケーション

* サーバ側
    - CountUpServletのcount変数を1sごとにインクリメントします。

* クライアント側
    - countの値をJSONで取得するために、10sごとにポーリングします。

# 起動方法

* mvn tomcat7:run

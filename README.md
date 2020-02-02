# Spring-Boot-Sample

TERASOLUNAガイドラインのアプリケーションのレイヤに基づいてSpring-Bootのサンプル。

＜TERASOLUNA Server Framework for Java (5.x) Development Guideline　2.4. アプリケーションのレイヤ化＞
http://terasolunaorg.github.io/guideline/5.5.1.RELEASE/ja/Overview/ApplicationLayering.html#applicationlayering

アプリケーションのほかに以下のサンプルも一般的なシステム開発で必要となる以下のサンプルも作成。

| 機能     | 説明                                         | 実装クラス                            |
|--------|--------------------------------------------|----------------------------------|
| ログ制御   | 各レイヤの呼び出し前後にAOPでログを差し込む制御                  | HttpRequestHandlerInterceptor、など |
| 例外制御   | Controllerが例外をthrowした場合にAOPでキャッチし、例外処理を実行。 | ExceptionInterceptor             |
| フィルタ制御 | リクエストURLよって個別の制御を差し込む。                     | 未                                |


また、各レイヤの単体テストのひな形も作成。（作成中）


各クラスの詳細は以下フォルダに格納しているJavacdocに各パッケージの説明を記載。

https://github.com/Kohei-Kato/Spring-Boot-Sample/tree/master/doc
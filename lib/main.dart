import 'dart:io';

import 'package:dio/dio.dart';
import 'package:flutter/material.dart';
import 'package:intl/intl.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home: MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title}) : super(key: key);

  bool isDone = false;
  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  String responseMsg = 'Milliseconds';
  final Dio dio = Dio();

  void _incrementCounterflutter() async {
    DateTime dateTime = DateTime.now();
    print('Before: ${new DateFormat('dd-MM-yyyy hh:mm:ss').format(new DateTime.now())}');

    await dio.get("https://jsonplaceholder.typicode.com/todos/1");

    setState(() {
      responseMsg = 'Flutter - Milliseconds: ${DateTime.now().difference(dateTime).inMilliseconds}';
    });
  }


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text(widget.title)),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text(responseMsg ?? 'Time taken'),

            SizedBox(height: 16),
            RaisedButton(
              color: Colors.blue,
              child: Text("API CALL"),
              onPressed: _incrementCounterflutter,
            )
          ],
        ),
      ),
    );
  }
}

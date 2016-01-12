package org.fm.bookstore.service.bookstore.client;

import org.fm.bookstore.service.BookstoreServer;
import org.fm.bookstore.service.books.domain.repository.BookRepository;
import org.fm.bookstore.service.database.utils.data.TestDataInitializer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

public class BookstoreClient extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        StackPane root = new StackPane();

        WebView view = new WebView();
        WebEngine engine = view.getEngine();
        engine.load("http://localhost:8080/bookstore/swagger-ui.html");
        root.getChildren().add(view);

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext ctx = SpringApplication.run(BookstoreServer.class, args);
        TestDataInitializer initializer = new TestDataInitializer(ctx.getBean(BookRepository.class));
        initializer.insertData();
        Application.launch(args);
    }
}

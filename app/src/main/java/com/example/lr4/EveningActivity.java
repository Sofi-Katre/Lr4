package com.example.lr4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.app.NotificationManager;
import android.os.Handler;

public class EveningActivity extends AppCompatActivity {

    private final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evening); // Устанавливаем макет evening.xml

        // Найдите ListView по его ID
        ListView morningList = findViewById(R.id.eveninglist);

        // Создайте массив строк с вашими задачами
        String[] tasks = {"Сериал Шерлок", "Гарри Поттер и Кубок Огня", "SPA в ванной", "Почитать перед сном книгу"};

        // Создайте стандартный ArrayAdapter, используя встроенный макет simple_list_item_1
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);

        // Установите адаптер для ListView
        morningList.setAdapter(adapter);

        // Найдем кнопки по их ID
        Button backButton = findViewById(R.id.btn_back);
        Button nextButton = findViewById(R.id.btn_next2);

        // Создаем экземпляр класса для пуш-уведомлений
        MyPushNotification myPushNotification = new MyPushNotification(this, getSystemService(NotificationManager.class));

        // Отправляем уведомление через 2 секунды после открытия окна
        handler.postDelayed(() -> {
            myPushNotification.sendNotify("Уведомление", "Пора спать!");
        }, 2000);

        // Слушатель для кнопки "назад"
        backButton.setOnClickListener(v -> {
            // Создаём Intent для возврата на MainActivity
            Intent intent = new Intent(EveningActivity.this, MainActivity.class);
            startActivity(intent);
        });

        // Слушатель для кнопки "далее"
        nextButton.setOnClickListener(v -> {
            // Создаем Intent для запуска EveningActivity
            Intent intent = new Intent(EveningActivity.this, NightActivity.class);
            startActivity(intent);
        });

    }

    // Метод для безопасной отмены Handler
    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacksAndMessages(null);
    }

}

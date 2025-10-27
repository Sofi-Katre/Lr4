package com.example.lr4;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button; // Не забудьте импортировать Button
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;

public class DayActivity extends AppCompatActivity {

    private final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day); // Устанавливаем макет day.xml

        // ListView по его ID
        ListView dayList = findViewById(R.id.daylist);

        // Массив строк со значениями
        String[] tasks = {"В 09:00 - Зарядка", "С 13:00 до 13:45 - Обед", "С 14:00 до 14:20 - Учебная тревога"};

        // Стандартный ArrayAdapter, используя встроенный макет simple_list_item_1
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);

        // Адаптер для ListView
        dayList.setAdapter(adapter);

        // Найдем кнопки по их ID
        Button backButton = findViewById(R.id.btn_back);
        Button nextButton = findViewById(R.id.btn_next1);

        // Создаем экземпляр класса для пуш-уведомлений
        MyPushNotification myPushNotification = new MyPushNotification(this, getSystemService(NotificationManager.class));

        // Отправляем уведомление через 2 секунды после открытия окна
        handler.postDelayed(() -> {
            myPushNotification.sendNotify("Уведомление", "Скоро конец рабочего дня!");
        }, 2000);

        // Слушатель для кнопки "назад"
        backButton.setOnClickListener(v -> {
            // Создаём Intent для возврата на MainActivity
            Intent intent = new Intent(DayActivity.this, MainActivity.class);
            startActivity(intent);
        });

        // Слушатель для кнопки "далее"
        nextButton.setOnClickListener(v -> {
            // Создаем Intent для запуска EveningActivity
            Intent intent = new Intent(DayActivity.this, EveningActivity.class);
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

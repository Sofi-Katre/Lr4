package com.example.lr4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button; // Не забудьте импортировать Button
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MorningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.morning); // Устанавливаем макет morning.xml

        // Найдите ListView по его ID
        ListView morningList = findViewById(R.id.moninglist);

        // Создайте массив строк с вашими задачами
        String[] tasks = {"Почистить зубы", "Позавтракать", "Собраться", "Пойти на работу"};

        // Создайте стандартный ArrayAdapter, используя встроенный макет simple_list_item_1
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);

        // Установите адаптер для ListView
        morningList.setAdapter(adapter);

        // Найдите кнопки по их ID
        Button backButton = findViewById(R.id.btn_back);
        Button nextButton = findViewById(R.id.btn_next);

        // Слушатель для кнопки "назад"
        backButton.setOnClickListener(v -> {
            // Закрываем текущую активность и возвращаемся к предыдущей
            finish();
        });

        // Слушатель для кнопки "далее"
        nextButton.setOnClickListener(v -> {
            // Создаем Intent для запуска DayActivity
            Intent intent = new Intent(MorningActivity.this, DayActivity.class);
            startActivity(intent);
        });
    }
}

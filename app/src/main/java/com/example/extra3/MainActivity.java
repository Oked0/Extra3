package com.example.extra3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Объявляем объекты для работы с UI
    private TextView dogNameTextView;
    private TextView dogBreedTextView;
    private TextView catNameTextView;
    private TextView catColorTextView;
    private TextView soundTextView;
    private Button makeSoundButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Связываем объекты с элементами UI
        dogNameTextView = findViewById(R.id.dogNameTextView);
        dogBreedTextView = findViewById(R.id.dogBreedTextView);
        catNameTextView = findViewById(R.id.catNameTextView);
        catColorTextView = findViewById(R.id.catColorTextView);
        soundTextView = findViewById(R.id.soundTextView);
        makeSoundButton = findViewById(R.id.makeSoundButton);

        // Создаем объекты классов
        Dog dog = new Dog("Дружок", 3, "Овчарка");
        Cat cat = new Cat("Мурзик", 2, "Чёрный");

        // Отображаем информацию о животных
        dogNameTextView.setText("Имя собаки: " + dog.getName());
        dogBreedTextView.setText("Порода собаки: " + dog.getBreed());
        catNameTextView.setText("Имя кошки: " + cat.getName());
        catColorTextView.setText("Цвет кошки: " + cat.getColor());

        // Обработка нажатия кнопки
        makeSoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Вызываем методы makeSound() и отображаем результат
                String dogSound = "Собака: " + getSound(dog);
                String catSound = "Кот: " + getSound(cat);
                soundTextView.setText(dogSound + "\n" + catSound);
            }
        });
    }

    // Метод для получения звука животного
    private String getSound(Animal animal) {
        // Создаем буфер для хранения звука
        StringBuilder soundBuffer = new StringBuilder();

        // Вызываем метод makeSound() и сохраняем звук в буфер
        String sound = animal.makeSound(); // Получаем звук от животного
        soundBuffer.append(animal.getClass().getSimpleName())
                .append(": ")
                .append(sound); // Добавляем звук в буфер

        // Возвращаем строку с звуком
        return soundBuffer.toString();
    }
}
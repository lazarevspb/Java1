package lesson6;

import java.io.FileNotFoundException;

/**
 * Homework for lesson #5
 *
 * Задание:
 * 1.Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);
 * 2.Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
 * 3.* Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле
 * (работаем только с латиницей).
 * 4.** Написать метод, проверяющий, есть ли указанное слово в папке.
 *
 * @author Valeriy Lazarev
 * @since 12.08.2020
 */
public class Main extends SubStringSearchInDirectory {


    public static void main(String[] args) {
        StringResources stringResources = new StringResources();

        try {
            /*Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);*/
            createTextFile("treasure_Island1.txt", stringResources.getTreasureIsland());
            createTextFile("treasure_Island2.txt", stringResources.getTreasureIsland2());

            /*Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла,
             потом текст из второго.*/
            System.out.println(mergeTextMethod("treasure_Island1.txt", "treasure_Island2.txt"));

            /* Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле
            (работаем только с латиницей).*/
            System.out.println((searchString("treasure_Island2.txt", "looked")) ?
                    "Заданное слово найдено в указанном файле." : "Заданное слово не найдено в указанном файле.");

            /* ** Написать метод, проверяющий, есть ли указанное слово в папке*/
            System.out.println(searchInDirectory(".", "breakfast") ?
                    "Заданное слово найдено в указанном каталоге." : "Заданное слово НЕ найдено в указанном каталоге.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

/*
Вывод:

        My father had an inn near the sea. It was a quiet place. One day,
        an old man came to our door. He was tall and strong, and his face
        was brown. His old blue coat was dirty and he had a big old box
        with him. He looked at the inn, then he looked at the sea.
         My father came to the door.
         At first the old man did not speak. He looked again at the sea,
        and at the front of the inn.
         `I like this place,` he said. `Do many people come here?`
        `No,` said my father.
        `I`m going to stay here,` said the old man. `I want a bed and
        food. I like watching the sea and the ships. You can call me
        Captain.`
        He threw some money on the table. `That`s for my bed and my
        food,` he said.
        And so the old captain came to stay with us. He was always
        quiet. In the evenings he sat in the inn and in the day he watched
        the sea and the ships.
        One day he spoke to me. `Come here, boy,` he said, and he
        gave me some money. `Take this, and look out for a sailor with
        one leg.`
        He was afraid of that sailor with one leg. I was afraid too. I
        looked for the man with one leg, but I never saw him.
        Then winter came, and it was very cold. My father was ill, and
        my mother and I worked very hard.
        Early one January morning, the captain went to the beach. I
        helped my mother to make the captain`s breakfast. The door
        opened and a man came in. His face was very white and he had
        only three ringers on his left hand. I could see that he was a sailor.
         `Can I help you?` I asked.

        The man looked at the captain's breakfast table.
        'Is this table for my friend Bill?' he asked.
        'I don't know your friend Bill,' I said. 'It's the captain's table.'
        'The captain?' he said. 'Well, they sometimes call my friend
        Bill the Captain. Is he here in the house?'
        'No. He's out,' I said.
        The man sat down and waited for the captain. Then the captain
        came into the room. He went to his table and sat down.
        'Bill!' said the man.
        The captain turned round quickly. His face went white.
        Suddenly, he looked old and ill.
        'Come, Bill, you know me. You know an old friend, Bill,' said
        the man.
        'Black Dog!' said the captain.
        'Yes,' said the man. 'It's me, Black Dog. I wanted to see my
        old friend Billy.'
        'Well, here I am,' said the captain. 'What do you want?'
        'I want to talk to you, Bill,' Black Dog said.
        The captain looked at me. 'Leave the room, boy,' he said, 'and
        don't listen at the door.'
        They talked for a long time. Then I heard them talking angrily.
        'No, no, no!' said the captain. There was a fight and then Black
        Dog ran out of the house.
        The captain's face was white. 'I must get out of here!' he said.
        I ran to get him a drink. I came back and found the captain on
        the floor. His eyes were closed.
        Our doctor, Dr Livesey, came and looked at the old captain.
        'He's very ill,' said the doctor.
        The captain opened his eyes and looked at the doctor. 'Where's
        Black Dog?' he asked.
        'There's no Black Dog here,' said the doctor. 'Now, Billy
        Bones, you must. . .'

        Заданное слово найдено в указанном файле.
        Заданное слово найдено в указанном каталоге.

Process finished with exit code 0
*/
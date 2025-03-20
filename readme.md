Задача: Подмножества с нулевой суммой

Описание:
Дан массив целых чисел, который может содержать как положительные, так и отрицательные значения.
Необходимо найти все подмножества, состоящие из 2 до N элементов (где N — длина массива), сумма которых равна нулю.

Требования:

1. Рассматривать все подмножества любого размера от 2 до N.
2. Вывести на экран общее количество подмножеств, сумма элементов которых равна нулю.
3. Не нужно устранять дублирующие комбинации, то есть если алгоритм генерирует [A, B] и [B, A] как разные варианты, их можно считать отдельными.
4. Алгоритм должен корректно работать для массивов произвольного размера, хотя для тестирования можно использовать массив из 8 чисел.
5. Задачу можно реализовать на любом языке программирования, который вам известен.
6. В ответе должен быть приведен алгоритм и дополнительно указан язык программирования используемый при решении.
7. При решении нужно учитывать порядок элементов

Пример:
Для массива:  [1, -1, 2, -2, 3, -3, 4, -4] <br/>
возможные подмножества с суммой ноль могут включать, например:<br/>
[1, -1], [2, -2], [3, -3], [4, -4], [1, -1, 2, -2] и т.д.<br/>
Итоговый вывод — общее количество таких подмножеств.
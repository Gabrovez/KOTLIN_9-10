# Лабораторная работа №9-10: Продвинутое ООП на Kotlin
## Описание 
Лабораторная работа посвящена изучению продвинутых  концепций объектно- ориентированного программирования в Kotlin.
## Структура проекта 
Проект содердит примеры реализациипродвинутых механизмов ООП, а также пояснения к ключевым концепциям
## Как запустить проект
1.  Клонируйте репозиторий: 
```bash
git clone <https://github.com/Gabrovez/Kotlin_Advanced_Lab_9_10_Kat>
```
2. Откройте проект в IntelliJ Idea.
3. Запустите любой пример через контекстное меню или напрямую из `main`.
## Автор
[Катаржин Григорий Михайлович]
## Лицензия
Проект создан в учебных целях 
## Геттеры и сеттеры
Геттеры и сеттеры — это специальные методы, которые позволяют контролировать доступ к свойствам класса. В Kotlin они могут быть определены кастомно для добавления логики при чтении (геттер) или изменении (сеттер) значения свойства.
### Содержит:
1. Кастомный сеттер — позволяет валидировать или преобразовывать входное значение перед присвоением.
2. Кастомный геттер — позволяет модифицировать или вычислять значение при его чтении.
3. Приватный сеттер (`private set`) — ограничивает возможность изменения свойства только внутри класса.
4. Ключевое слово `field` — ссылается на фактическое значение свойства внутри кастомного геттера/сеттера.

### Пример

```kotlin
class Hero(val name: String) {
    var health: Int = 100
        set(value) {
            field = value.coerceIn(0, 100)
        }

    var stamina: Int = 50
        get() = field + 10 

    var level: Int = 1
        private set 

    fun levelUp() {
        level++
        println("$name повысил уровень до $level!")
    }
}
```
## Инкапсуляция
Инкапсуляция — это принцип ООП, который скрывает внутреннее состояние объекта и предоставляет контролируемый доступ к нему через публичные методы и свойства.
### Содержит:

1. Использование модификаторов доступа (private, protected, internal, public).
2. Кастомные геттеры и сеттеры для контроля над изменениями.
3. Приватные сеттеры (private set) для свойств, которые должны изменяться только внутри класса.

### Пример

```kotlin
class OutpostWorker(val name: String) {
    private var _level: Int = 1
    val level: Int
        get() = _level
        private set(value) {
            _level = value
        }

    fun levelUp() {
        _level++ 
    }
}
```
## Data-классы
Data-классы предназначены для хранения данных. Kotlin автоматически генерирует стандартные методы: equals(), hashCode(), toString() и copy().

### Содержит:

1. Обязательный параметр в первичном конструкторе.
2. Автоматическую генерацию toString(), equals(), hashCode(), copy().
3. Функции декомпозиции (componentN()).

### Пример
```kotlin
data class OutpostResource(val id: Int, val name: String, var amount: Int)

val minerals = OutpostResource(1, "Minerals", 100)
val bonusMinerals = minerals.copy(amount = minerals.amount + 50)

println(minerals) 
println(bonusMinerals) 
```

## Абстрактные классы

Абстрактный класс — это базовый класс, от которого нельзя создать объект напрямую. Он может содержать как абстрактные, так и реализованные методы и свойства.

### Содержит:

1. Абстрактные методы (без реализации).
2. Абстрактные свойства (без значения).
3. Обычные методы и свойства с реализацией.
4. Наследование (только одно).
### Пример

```kotlin
abstract class OutpostModule(val name: String, var level: Int) {
    abstract fun performAction()

    fun upgrade() {
        level++
        println("$name upgraded to level $level")
    }
}

class EnergyGenerator(name: String, level: Int) : OutpostModule(name, level) {
    override fun performAction() {
        println("Energy generator is producing energy...")
    }
}
```

## Интерфейсы

Интерфейс — это контракт поведения, который класс обязуется реализовать. Может содержать объявления методов и свойств, а также их реализацию по умолчанию.

### Содержит:

1. Абстрактные методы и свойства без реализации.
2. Реализацию по умолчанию для методов.
3. Возможность множественной реализации интерфейсов.

### Пример

```kotlin
interface VideoPlayable{
    fun play() = println("Play video")
}
interface AudioPlayable{
    fun play() = println("Play audio")
}
class MediaPlayer: VideoPlayable, AudioPlayable{
    override fun play() {
        println("Start playing")
        super<VideoPlayable>.play()
        super<AudioPlayable>.play()
    }
}
```
## Galaxy Outpost Manager
***
Учебный проект на Kotlin, демонстрирующий основы объектно-ориентированного программирования и
архитектурные приёмы языка.
___
### Sealed-классы
***
**Sealed-классы** используются для представления ограниченного набора состояний или результатов, которые
известны на этапе компиляции. 

Они позволяют:
* гарантировать обработку всех возможных вариантов;
* безопасно использовать конструкцию when без else;
* удобно описывать состояния, события и результаты действий.
#### Пример: результат работы модуля
```kotlin
sealed-class ModuleResult {
    data class Success(val message: String) : ModuleResult()
    data class ResourceProduced(val resourceName: String, val amount: Int) : ModuleResult()
    data class NotEnoughResources(
        val resourceName: String,
        val required: Int,
        val available: Int
    ) : ModuleResult()
    data class Error(val reason: String) : ModuleResult()
}
```
### Object в Kotlin
***
**Object** — это специальная конструкция Kotlin, которая создаёт единственный экземпляр класса (Singleton).

Особенности:
* создаётся при первом обращении;
* существует в одном экземпляре;
* не имеет конструктора.
#### Пример: глобальный логгер
```kotlin
object Logger {
private var counter = 0
    
    fun log(message: String) {
        counter++
        println("[$counter] $message")
    }
}
```
#### Использование:
```kotlin

Logger.log("Инициализация системы")
Logger.log("Модуль запущен")
```
**Object** удобно использовать для:
* логгеров;
* конфигураций;
* состояний без данных в sealed-классах;
* утилитарных классов.
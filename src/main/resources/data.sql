TRUNCATE TABLE quiz_options, quiz_answers, quiz RESTART IDENTITY CASCADE;

-- kotlin variable declaration
INSERT INTO quiz (title, text)
VALUES ('Kotlin Variable Declaration', 'How do you declare a read-only integer variable in Kotlin?');
INSERT INTO quiz_options (quiz_id, options)
VALUES (1, 'val x: Int = 5');
INSERT INTO quiz_options (quiz_id, options)
VALUES (1, 'var x: Int = 5');
INSERT INTO quiz_options (quiz_id, options)
VALUES (1, 'int x = 5');
INSERT INTO quiz_options (quiz_id, options)
VALUES (1, 'const x = 5');
INSERT INTO quiz_answers (quiz_id, answers)
VALUES (1, 0);

-- kotlin null safety
INSERT INTO quiz (title, text)
VALUES ('Kotlin Null Safety', 'Which operator is used to safely access a nullable variable in Kotlin?');
INSERT INTO quiz_options (quiz_id, options)
VALUES (2, '?.');
INSERT INTO quiz_options (quiz_id, options)
VALUES (2, '!!');
INSERT INTO quiz_options (quiz_id, options)
VALUES (2, '?:');
INSERT INTO quiz_options (quiz_id, options)
VALUES (2, '.');
INSERT INTO quiz_answers (quiz_id, answers)
VALUES (2, 0);

-- kotlin data classes
INSERT INTO quiz (title, text)
VALUES ('Kotlin Data Classes', 'What is automatically provided by a Kotlin data class?');
INSERT INTO quiz_options (quiz_id, options)
VALUES (3, 'toString()');
INSERT INTO quiz_options (quiz_id, options)
VALUES (3, 'main()');
INSERT INTO quiz_options (quiz_id, options)
VALUES (3, 'equals() and hashCode()');
INSERT INTO quiz_options (quiz_id, options)
VALUES (3, 'finalize()');
INSERT INTO quiz_answers (quiz_id, answers)
VALUES (3, 0);
INSERT INTO quiz_answers (quiz_id, answers)
VALUES (3, 2);

-- kotlin functions
INSERT INTO quiz (title, text)
VALUES ('Kotlin Functions', 'Which keyword defines a function in Kotlin?');
INSERT INTO quiz_options (quiz_id, options)
VALUES (4, 'fun');
INSERT INTO quiz_options (quiz_id, options)
VALUES (4, 'function');
INSERT INTO quiz_options (quiz_id, options)
VALUES (4, 'def');
INSERT INTO quiz_options (quiz_id, options)
VALUES (4, 'method');
INSERT INTO quiz_answers (quiz_id, answers)
VALUES (4, 0);

-- kotlin loops
INSERT INTO quiz (title, text)
VALUES ('Kotlin Loops', 'Which Kotlin loop construct is best for iterating over a list with indices?');
INSERT INTO quiz_options (quiz_id, options)
VALUES (5, 'for (item in list)');
INSERT INTO quiz_options (quiz_id, options)
VALUES (5, 'for (i in list.indices)');
INSERT INTO quiz_options (quiz_id, options)
VALUES (5, 'while (item in list)');
INSERT INTO quiz_options (quiz_id, options)
VALUES (5, 'do-while loop');
INSERT INTO quiz_answers (quiz_id, answers)
VALUES (5, 1);

-- kotlin extension functions
INSERT INTO quiz (title, text)
VALUES ('Kotlin Extension Functions', 'What is true about extension functions in Kotlin?');
INSERT INTO quiz_options (quiz_id, options)
VALUES (6, 'They modify the original class');
INSERT INTO quiz_options (quiz_id, options)
VALUES (6, 'They add functionality without modifying the class');
INSERT INTO quiz_options (quiz_id, options)
VALUES (6, 'They can only be private');
INSERT INTO quiz_options (quiz_id, options)
VALUES (6, 'They replace existing methods');
INSERT INTO quiz_answers (quiz_id, answers)
VALUES (6, 1);

-- kotlin collections
INSERT INTO quiz (title, text)
VALUES ('Kotlin Collections', 'Which Kotlin function filters elements in a collection?');
INSERT INTO quiz_options (quiz_id, options)
VALUES (7, 'map()');
INSERT INTO quiz_options (quiz_id, options)
VALUES (7, 'filter()');
INSERT INTO quiz_options (quiz_id, options)
VALUES (7, 'reduce()');
INSERT INTO quiz_options (quiz_id, options)
VALUES (7, 'forEach()');
INSERT INTO quiz_answers (quiz_id, answers)
VALUES (7, 1);

-- kotlin coroutines
INSERT INTO quiz (title, text)
VALUES ('Kotlin Coroutines', 'Which keyword is used to define a coroutine scope in Kotlin?');
INSERT INTO quiz_options (quiz_id, options)
VALUES (8, 'async');
INSERT INTO quiz_options (quiz_id, options)
VALUES (8, 'launch');
INSERT INTO quiz_options (quiz_id, options)
VALUES (8, 'suspend');
INSERT INTO quiz_options (quiz_id, options)
VALUES (8, 'coroutine');
INSERT INTO quiz_answers (quiz_id, answers)
VALUES (8, 2);

-- kotlin lambdas
INSERT INTO quiz (title, text)
VALUES ('Kotlin Lambdas', 'What is the syntax for a lambda expression in Kotlin?');
INSERT INTO quiz_options (quiz_id, options)
VALUES (9, '{ x -> x * 2 }');
INSERT INTO quiz_options (quiz_id, options)
VALUES (9, '(x) => x * 2');
INSERT INTO quiz_options (quiz_id, options)
VALUES (9, 'lambda x: x * 2');
INSERT INTO quiz_options (quiz_id, options)
VALUES (9, 'function(x) { x * 2 }');
INSERT INTO quiz_answers (quiz_id, answers)
VALUES (9, 0);

-- kotlin sealed classes
INSERT INTO quiz (title, text)
VALUES ('Kotlin Sealed Classes', 'What is a sealed class used for in Kotlin?');
INSERT INTO quiz_options (quiz_id, options)
VALUES (10, 'To prevent instantiation');
INSERT INTO quiz_options (quiz_id, options)
VALUES (10, 'To restrict class hierarchy');
INSERT INTO quiz_options (quiz_id, options)
VALUES (10, 'To allow multiple inheritance');
INSERT INTO quiz_options (quiz_id, options)
VALUES (10, 'To make classes immutable');
INSERT INTO quiz_answers (quiz_id, answers) VALUES (10, 1);
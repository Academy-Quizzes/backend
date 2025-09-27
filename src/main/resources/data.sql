TRUNCATE TABLE quiz_options, quiz_answers, quiz RESTART IDENTITY CASCADE;

-- kotlin variable declaration
INSERT INTO quiz (title, text)
VALUES ('Kotlin Variable Declaration', 'How do you declare a read-only integer variable in Kotlin?');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'val x: Int = 5');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'var x: Int = 5');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'int x = 5');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'const x = 5');
INSERT INTO quiz_answers (quiz_id, answers)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 0);

-- kotlin null safety
INSERT INTO quiz (title, text)
VALUES ('Kotlin Null Safety', 'Which operator is used to safely access a nullable variable in Kotlin?');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), '?.');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), '!!');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), '?:');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), '.');
INSERT INTO quiz_answers (quiz_id, answers)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 0);

-- kotlin data classes
INSERT INTO quiz (title, text)
VALUES ('Kotlin Data Classes', 'What is automatically provided by a Kotlin data class?');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'toString()');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'main()');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'equals() and hashCode()');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'finalize()');
INSERT INTO quiz_answers (quiz_id, answers)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 0);
INSERT INTO quiz_answers (quiz_id, answers)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 2);

-- kotlin functions
INSERT INTO quiz (title, text)
VALUES ('Kotlin Functions', 'Which keyword defines a function in Kotlin?');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'fun');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'function');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'def');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'method');
INSERT INTO quiz_answers (quiz_id, answers)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 0);

-- kotlin loops
INSERT INTO quiz (title, text)
VALUES ('Kotlin Loops', 'Which Kotlin loop construct is best for iterating over a list with indices?');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'for (item in list)');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'for (i in list.indices)');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'while (item in list)');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'do-while loop');
INSERT INTO quiz_answers (quiz_id, answers)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 1);

-- kotlin extension functions
INSERT INTO quiz (title, text)
VALUES ('Kotlin Extension Functions', 'What is true about extension functions in Kotlin?');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'They modify the original class');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'They add functionality without modifying the class');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'They can only be private');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'They replace existing methods');
INSERT INTO quiz_answers (quiz_id, answers)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 1);

-- kotlin collections
INSERT INTO quiz (title, text)
VALUES ('Kotlin Collections', 'Which Kotlin function filters elements in a collection?');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'map()');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'filter()');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'reduce()');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'forEach()');
INSERT INTO quiz_answers (quiz_id, answers)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 1);

-- kotlin coroutines
INSERT INTO quiz (title, text)
VALUES ('Kotlin Coroutines', 'Which keyword is used to define a coroutine scope in Kotlin?');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'async');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'launch');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'suspend');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'coroutine');
INSERT INTO quiz_answers (quiz_id, answers)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 2);

-- kotlin lambdas
INSERT INTO quiz (title, text)
VALUES ('Kotlin Lambdas', 'What is the syntax for a lambda expression in Kotlin?');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), '{ x -> x * 2 }');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), '(x) => x * 2');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'lambda x: x * 2');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'function(x) { x * 2 }');
INSERT INTO quiz_answers (quiz_id, answers)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 0);

-- kotlin sealed classes
INSERT INTO quiz (title, text)
VALUES ('Kotlin Sealed Classes', 'What is a sealed class used for in Kotlin?');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'To prevent instantiation');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'To restrict class hierarchy');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'To allow multiple inheritance');
INSERT INTO quiz_options (quiz_id, options)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 'To make classes immutable');
INSERT INTO quiz_answers (quiz_id, answers)
VALUES (currval(pg_get_serial_sequence('quiz', 'id')), 1);
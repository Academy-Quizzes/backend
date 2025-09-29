TRUNCATE TABLE question_options, question_answers, question RESTART IDENTITY CASCADE;
TRUNCATE TABLE topics RESTART IDENTITY CASCADE;

-- default topic only one as of now for testing purposes
INSERT INTO topics (name) VALUES ('General');
INSERT INTO topics (name) VALUES ('Kotlin');
INSERT INTO topics (name) VALUES ('PostgreSQL');

-- kotlin variable declaration
INSERT INTO question (title, text)
VALUES ('Kotlin Variable Declaration', 'How do you declare a read-only integer variable in Kotlin?');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'val x: Int = 5');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'var x: Int = 5');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'int x = 5');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'const x = 5');
INSERT INTO question_answers (question_id, answers)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 0);
INSERT INTO question_topics (question_id, topic_id) VALUES (1, 1);

-- kotlin null safety
INSERT INTO question (title, text)
VALUES ('Kotlin Null Safety', 'Which operator is used to safely access a nullable variable in Kotlin?');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), '?.');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), '!!');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), '?:');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), '.');
INSERT INTO question_answers (question_id, answers)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 0);
INSERT INTO question_topics (question_id, topic_id)
VALUES (2,1);
INSERT INTO question_topics (question_id, topic_id)
VALUES (2,2);
-- kotlin data classes
INSERT INTO question (title, text)
VALUES ('Kotlin Data Classes', 'What is automatically provided by a Kotlin data class?');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'toString()');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'main()');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'equals() and hashCode()');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'finalize()');
INSERT INTO question_answers (question_id, answers)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 0);
INSERT INTO question_answers (question_id, answers)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 2);
INSERT INTO question_topics (question_id, topic_id)
VALUES (3, 1);
INSERT INTO question_topics (question_id, topic_id)
VALUES (3, 2);
INSERT INTO question_topics (question_id, topic_id)
VALUES (3, 3);
-- kotlin functions
INSERT INTO question (title, text)
VALUES ('Kotlin Functions', 'Which keyword defines a function in Kotlin?');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'fun');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'function');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'def');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'method');
INSERT INTO question_answers (question_id, answers)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 0);
INSERT INTO question_topics (question_id, topic_id)
VALUES (4,1);
-- kotlin loops
INSERT INTO question (title, text)
VALUES ('Kotlin Loops', 'Which Kotlin loop construct is best for iterating over a list with indices?');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'for (item in list)');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'for (i in list.indices)');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'while (item in list)');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'do-while loop');
INSERT INTO question_answers (question_id, answers)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 1);
INSERT INTO question_topics (question_id, topic_id)
VALUES (5,1);
-- kotlin extension functions
INSERT INTO question (title, text)
VALUES ('Kotlin Extension Functions', 'What is true about extension functions in Kotlin?');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'They modify the original class');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'They add functionality without modifying the class');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'They can only be private');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'They replace existing methods');
INSERT INTO question_answers (question_id, answers)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 1);
INSERT INTO question_topics (question_id, topic_id)
VALUES (6,1);
-- kotlin collections
INSERT INTO question (title, text)
VALUES ('Kotlin Collections', 'Which Kotlin function filters elements in a collection?');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'map()');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'filter()');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'reduce()');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'forEach()');
INSERT INTO question_answers (question_id, answers)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 1);
INSERT INTO question_topics (question_id, topic_id)
VALUES (7,1);
-- kotlin coroutines
INSERT INTO question (title, text)
VALUES ('Kotlin Coroutines', 'Which keyword is used to define a coroutine scope in Kotlin?');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'async');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'launch');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'suspend');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'coroutine');
INSERT INTO question_answers (question_id, answers)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 2);
INSERT INTO question_topics (question_id, topic_id)
VALUES (8,1);
-- kotlin lambdas
INSERT INTO question (title, text)
VALUES ('Kotlin Lambdas', 'What is the syntax for a lambda expression in Kotlin?');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), '{ x -> x * 2 }');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), '(x) => x * 2');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'lambda x: x * 2');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'function(x) { x * 2 }');
INSERT INTO question_answers (question_id, answers)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 0);
INSERT INTO question_topics (question_id, topic_id)
VALUES (9,1);
-- kotlin sealed classes
INSERT INTO question (title, text)
VALUES ('Kotlin Sealed Classes', 'What is a sealed class used for in Kotlin?');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'To prevent instantiation');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'To restrict class hierarchy');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'To allow multiple inheritance');
INSERT INTO question_options (question_id, options)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 'To make classes immutable');
INSERT INTO question_answers (question_id, answers)
VALUES (currval(pg_get_serial_sequence('question', 'id')), 1);
INSERT INTO question_topics (question_id, topic_id)
VALUES (10,1);
INSERT INTO question_topics (question_id, topic_id)
VALUES (10,2);
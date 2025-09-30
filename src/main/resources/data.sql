-- resets users,roles,question_options ..etc and cascades
TRUNCATE TABLE users,roles, question_options, question_answers, question_topics, question RESTART IDENTITY CASCADE;
-- seed in topics
INSERT INTO topics (id, name) VALUES (1, 'General')
    ON CONFLICT (id) DO NOTHING;
INSERT INTO topics (id, name) VALUES (2, 'Kotlin')
    ON CONFLICT (id) DO NOTHING;
INSERT INTO topics (id, name) VALUES (3, 'PostgreSQL')
    ON CONFLICT (id) DO NOTHING;

-- kotlin variable declaration
INSERT INTO question (title, text, creator_id)
VALUES ('Kotlin Variable Declaration', 'How do you declare a read-only integer variable in Kotlin?',1);
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
INSERT INTO question (title, text, creator_id)
VALUES ('Kotlin Null Safety', 'Which operator is used to safely access a nullable variable in Kotlin?',1);
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
INSERT INTO question (title, text, creator_id)
VALUES ('Kotlin Data Classes', 'What is automatically provided by a Kotlin data class?',3);
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
INSERT INTO question (title, text, creator_id)
VALUES ('Kotlin Functions', 'Which keyword defines a function in Kotlin?',1);
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
INSERT INTO question (title, text, creator_id)
VALUES ('Kotlin Loops', 'Which Kotlin loop construct is best for iterating over a list with indices?',1);
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
INSERT INTO question (title, text, creator_id)
VALUES ('Kotlin Extension Functions', 'What is true about extension functions in Kotlin?',4);
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
INSERT INTO question (title, text, creator_id)
VALUES ('Kotlin Collections', 'Which Kotlin function filters elements in a collection?',4);
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
INSERT INTO question (title, text, creator_id)
VALUES ('Kotlin Coroutines', 'Which keyword is used to define a coroutine scope in Kotlin?',1);
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
INSERT INTO question (title, text, creator_id)
VALUES ('Kotlin Lambdas', 'What is the syntax for a lambda expression in Kotlin?',3);
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
INSERT INTO question (title, text, creator_id)
VALUES ('Kotlin Sealed Classes', 'What is a sealed class used for in Kotlin?',4);
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

--Quizzes
INSERT INTO quizzes (id, title, description, created_at, topic_id)
VALUES (1, 'Introduction to Kotlin', 'Learn the basics of Kotlin, including variable declaration, null safety, and data classes', CURRENT_DATE, 2);

INSERT INTO quiz_questions (quiz_id, question_id) VALUES (1, 1);
INSERT INTO quiz_questions (quiz_id, question_id) VALUES (1, 2);
INSERT INTO quiz_questions (quiz_id, question_id) VALUES (1, 3);

INSERT INTO quizzes (id, title, description, created_at, topic_id)
VALUES (2, 'Kotlin Functions and Loops', 'Get introduced to Kotlin functions and looping constructs.', CURRENT_DATE, 2);

INSERT INTO quiz_questions (quiz_id, question_id) VALUES (2, 4);
INSERT INTO quiz_questions (quiz_id, question_id) VALUES (2, 5);

INSERT INTO quizzes (id, title, description, created_at, topic_id)
VALUES (3, 'Advanced Kotlin Features', 'Explore advanced Kotlin features including extension functions, collections, and coroutines.', CURRENT_DATE, 2);

INSERT INTO quiz_questions (quiz_id, question_id) VALUES (3, 6);
INSERT INTO quiz_questions (quiz_id, question_id) VALUES (3, 7);
INSERT INTO quiz_questions (quiz_id, question_id) VALUES (3, 8);

INSERT INTO quizzes (id, title, description, created_at, topic_id)
VALUES (4, 'Functional Programming in Kotlin', 'Dive into Kotlin’s functional programming capabilities such as lambdas and sealed classes.', CURRENT_DATE, 2);

INSERT INTO quiz_questions (quiz_id, question_id) VALUES (4, 9);
INSERT INTO quiz_questions (quiz_id, question_id) VALUES (4, 10);

INSERT INTO quizzes (id, title, description, created_at, topic_id)
VALUES (5, 'Comprehensive Kotlin Knowledge', 'Test your overall knowledge of Kotlin with a mix of questions.', CURRENT_DATE, 2);

INSERT INTO quiz_questions (quiz_id, question_id) VALUES (5, 1);
INSERT INTO quiz_questions (quiz_id, question_id) VALUES (5, 2);
INSERT INTO quiz_questions (quiz_id, question_id) VALUES (5, 4);
INSERT INTO quiz_questions (quiz_id, question_id) VALUES (5, 6);
INSERT INTO quiz_questions (quiz_id, question_id) VALUES (5, 9);

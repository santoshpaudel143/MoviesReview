package com.imdb.developer.moviereview.controller;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Santosh Paudel
 */

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class AbstractIntegrationTest {
}

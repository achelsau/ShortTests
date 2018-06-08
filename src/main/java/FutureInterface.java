package com.tivo.tve.tests;

import java.util.List;
import java.util.concurrent.Future;

/**
 * Created by ariel on 06/11/2017.
 */
public interface FutureInterface {

    Future<List<String>> getListOfFutures();

}

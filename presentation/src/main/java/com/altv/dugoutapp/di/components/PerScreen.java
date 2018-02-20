package com.altv.dugoutapp.di.components;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by rubenbujalance on 13/02/2018.
 */

@Scope
@Retention(RUNTIME)
public @interface PerScreen {}

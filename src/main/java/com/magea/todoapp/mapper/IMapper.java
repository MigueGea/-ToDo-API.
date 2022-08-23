package com.magea.todoapp.mapper;

//Interfaz generica
public interface IMapper <I, O> { // I es la entrada y O es la salida
	public O map(I in);
}

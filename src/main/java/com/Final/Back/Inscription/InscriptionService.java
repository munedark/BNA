package com.Final.Back.Inscription;

public interface InscriptionService {
    boolean verficationClient(Long numeroCompte, Long cin);
    boolean identifiantExistant(String identifiant);
    void inscription(String Cin, String password);
}

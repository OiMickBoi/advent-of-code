{ pkgs ? import <nixpkgs> {} }:

pkgs.mkShell {
  buildInputs = [
    pkgs.openjdk11 
    pkgs.maven 
    pkgs.direnv
    pkgs.jdt-language-server
  ];
}

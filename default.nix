#Pin specific version of nix packages to work with java so it will always be reproducible.
#The following section is only necessary if this package is being run locally and not from
#the nix pkgs repository.
{ pkgs ? (import (builtins.fetchGit { 
  url = https://github.com/NixOS/nixpkgs-channels;
  ref = "nixos-19.09";
  rev = "a3070689aef665ba1f5cc7903a205d3eff082ce9";
}) {}) }:

#BookFinder nix package information
pkgs.stdenv.mkDerivation {
  pname = "book-finder";
  version = "1.0";
  src = ./.;

  #Add java packages here.
  buildInputs = with pkgs; [
    jdk
    sqlite
  ];

  installPhase = ''
  
    javac src/main/java/com/vpfeiffer/bookfinder/BookFinder.java
  '';

  #meta = ...
}


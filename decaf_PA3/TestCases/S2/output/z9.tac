VTABLE(_Main) {
    <empty>
    Main
    _Main.set;
    _Main.get;
}

FUNCTION(_Main_New) {
memo ''
_Main_New:
    _T3 = 8
    parm _T3
    _T4 =  call _Alloc
    _T5 = 0
    *(_T4 + 4) = _T5
    _T6 = VTBL <_Main>
    *(_T4 + 0) = _T6
    return _T4
}

FUNCTION(_Main.set) {
memo '_T0:4 _T1:8'
_Main.set:
    _T7 = *(_T0 + 4)
    *(_T0 + 4) = _T1
}

FUNCTION(_Main.get) {
memo '_T2:4'
_Main.get:
    _T9 = *(_T2 + 4)
    _T8 = _T9
    return _T8
}

FUNCTION(main) {
memo ''
main:
    _T11 =  call _Main_New
    _T10 = _T11
    _T12 = 5
    parm _T10
    parm _T12
    _T13 = *(_T10 + 0)
    _T14 = *(_T13 + 8)
    call _T14
    parm _T10
    _T15 = *(_T10 + 0)
    _T16 = *(_T15 + 12)
    _T17 =  call _T16
    parm _T10
    _T18 = *(_T10 + 0)
    _T19 = *(_T18 + 12)
    _T20 =  call _T19
    _T21 = (_T17 + _T20)
    parm _T10
    parm _T21
    _T22 = *(_T10 + 0)
    _T23 = *(_T22 + 8)
    call _T23
}


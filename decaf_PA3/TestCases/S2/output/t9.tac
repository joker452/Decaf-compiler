VTABLE(_Main) {
    <empty>
    Main
}

VTABLE(_A) {
    _Main
    A
    _A.func;
}

FUNCTION(_Main_New) {
memo ''
_Main_New:
    _T1 = 8
    parm _T1
    _T2 =  call _Alloc
    _T3 = 0
    *(_T2 + 4) = _T3
    _T4 = VTBL <_Main>
    *(_T2 + 0) = _T4
    return _T2
}

FUNCTION(_A_New) {
memo ''
_A_New:
    _T5 = 8
    parm _T5
    _T6 =  call _Alloc
    _T7 = 0
    *(_T6 + 4) = _T7
    _T8 = VTBL <_A>
    *(_T6 + 0) = _T8
    return _T6
}

FUNCTION(main) {
memo ''
main:
}

FUNCTION(_A.func) {
memo '_T0:4'
_A.func:
    _T9 = *(_T0 + 4)
    _T10 =  call _Main_New
    _T11 = *(_T10 + 4)
    *(_T0 + 4) = _T11
}

